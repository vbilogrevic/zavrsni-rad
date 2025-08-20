package hr.tvz.bilogrevic.zavrsniradbackend.service;

import hr.tvz.bilogrevic.zavrsniradbackend.model.SensorData;
import hr.tvz.bilogrevic.zavrsniradbackend.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    public void saveLastSensorReading(SensorData sensorData) {
        if(sensorData.getTimestamp() == null) {
            sensorData.setTimestamp(LocalDateTime.now());
        }
        sensorDataRepository.save(sensorData);
    }

    public Optional<SensorData> getLastSensorReading() {
        return sensorDataRepository.findTopByOrderByTimestampDesc();
    }

}
