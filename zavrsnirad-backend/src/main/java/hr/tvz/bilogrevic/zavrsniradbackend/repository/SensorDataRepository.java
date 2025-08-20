package hr.tvz.bilogrevic.zavrsniradbackend.repository;

import hr.tvz.bilogrevic.zavrsniradbackend.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {

    Optional<SensorData> findTopByOrderByTimestampDesc();
    List<SensorData> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);

}
