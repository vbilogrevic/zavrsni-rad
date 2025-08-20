package hr.tvz.bilogrevic.zavrsniradbackend.controller;

import hr.tvz.bilogrevic.zavrsniradbackend.model.SensorAverageData;
import hr.tvz.bilogrevic.zavrsniradbackend.model.SensorData;
import hr.tvz.bilogrevic.zavrsniradbackend.service.SensorAverageDataService;
import hr.tvz.bilogrevic.zavrsniradbackend.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensor")
@CrossOrigin(origins = "http://localhost:4200")
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private SensorAverageDataService sensorAverageDataService;


    @PostMapping("/data")
    public ResponseEntity<String> receiveSensorData(@RequestBody SensorData sensorData) {
        sensorDataService.saveLastSensorReading(sensorData);
        return ResponseEntity.ok("Očitan podatak - " + sensorData.getTimestamp());
    }

    @GetMapping("/last")
    public Optional<SensorData> getLastData(){
        return sensorDataService.getLastSensorReading();
    }

    @PostMapping("/calcaverage/{date}")
    public ResponseEntity<String> calculateDailyStatsForDate(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        sensorAverageDataService.calculateForDate(parsedDate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{date}")
    public Optional<SensorAverageData> calculateLastByDay(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return sensorAverageDataService.findByDay(parsedDate);
    }

    @GetMapping("/average")
    public List<SensorAverageData> getAllDailyStats() {
        return sensorAverageDataService.getAllSensorReadings();
    }

}
