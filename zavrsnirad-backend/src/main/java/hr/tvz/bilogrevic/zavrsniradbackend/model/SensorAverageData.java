package hr.tvz.bilogrevic.zavrsniradbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sensor_averages", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"day"}) })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorAverageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate day;

    private BigDecimal avgTemperature;
    private BigDecimal minTemperature;
    private BigDecimal maxTemperature;

    private BigDecimal avgHumidity;
    private BigDecimal minHumidity;
    private BigDecimal maxHumidity;
}
