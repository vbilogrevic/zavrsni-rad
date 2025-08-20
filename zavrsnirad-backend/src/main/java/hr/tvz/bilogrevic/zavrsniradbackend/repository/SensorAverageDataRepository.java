package hr.tvz.bilogrevic.zavrsniradbackend.repository;

import hr.tvz.bilogrevic.zavrsniradbackend.model.SensorAverageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SensorAverageDataRepository extends JpaRepository<SensorAverageData, Integer> {

    Optional<SensorAverageData> findByDay(LocalDate date);

}
