package hr.tvz.bilogrevic.zavrsniradbackend.service;

import hr.tvz.bilogrevic.zavrsniradbackend.model.SensorAverageData;
import hr.tvz.bilogrevic.zavrsniradbackend.model.SensorData;
import hr.tvz.bilogrevic.zavrsniradbackend.repository.SensorAverageDataRepository;
import hr.tvz.bilogrevic.zavrsniradbackend.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SensorAverageDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Autowired
    private SensorAverageDataRepository sensorAverageDataRepository;

    @Scheduled(cron = "0 5 0 * * *")
    public void scheduledDailyStats() {
        calculateForDate(LocalDate.now().minusDays(1));
    }

    public void calculateForDate(LocalDate date) {
        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = date.plusDays(1).atStartOfDay();

        List<SensorData> readings = sensorDataRepository.findByTimestampBetween(startDate, endDate);

        if(readings.isEmpty()) {
            System.out.println("Nema podataka za " + date);
            return;
        }

        BigDecimal sumTemp = BigDecimal.ZERO;
        BigDecimal minTemp = readings.get(0).getTemperature();
        BigDecimal maxTemp = readings.get(0).getTemperature();

        for(SensorData reading : readings) {
            BigDecimal temp = reading.getTemperature();
            sumTemp = sumTemp.add(temp);

            if(temp.compareTo(minTemp) < 0) {
                minTemp = temp;
            }
            if(temp.compareTo(maxTemp) > 0) {
                maxTemp = temp;
            }
        }

        BigDecimal avgTemp = sumTemp.divide(BigDecimal.valueOf(readings.size()), 2, RoundingMode.HALF_UP);

        BigDecimal sumHum = BigDecimal.ZERO;
        BigDecimal minHum = readings.get(0).getHumidity();
        BigDecimal maxHum = readings.get(0).getHumidity();

        for(SensorData reading : readings) {
            BigDecimal hum = reading.getHumidity();
            sumHum = sumHum.add(hum);

            if(hum.compareTo(minHum) < 0) {
                minHum = hum;
            }
            if(hum.compareTo(maxHum) > 0) {
                maxHum = hum;
            }
        }

        BigDecimal avgHum = sumHum.divide(BigDecimal.valueOf(readings.size()), 2, RoundingMode.HALF_UP);

        SensorAverageData stats = sensorAverageDataRepository.findByDay(date).orElseGet(SensorAverageData::new);

        stats.setDay(date);
        stats.setAvgTemperature(avgTemp.setScale(2, RoundingMode.HALF_UP));
        stats.setMinTemperature(minTemp.setScale(2, RoundingMode.HALF_UP));
        stats.setMaxTemperature(maxTemp.setScale(2, RoundingMode.HALF_UP));
        stats.setAvgHumidity(avgHum);
        stats.setMinHumidity(minHum.setScale(2, RoundingMode.HALF_UP));
        stats.setMaxHumidity(maxHum.setScale(2, RoundingMode.HALF_UP));

        sensorAverageDataRepository.save(stats);
        System.out.println("Statistika spremljena za " + date);
    }


    public Optional<SensorAverageData> findByDay(LocalDate date) {
        return sensorAverageDataRepository.findByDay(date);
    }

    public List<SensorAverageData> getAllSensorReadings() {
        return sensorAverageDataRepository.findAll();
    }
}
