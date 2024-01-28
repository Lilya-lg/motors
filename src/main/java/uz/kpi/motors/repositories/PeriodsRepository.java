package uz.kpi.motors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kpi.motors.models.Metrics;
import uz.kpi.motors.models.Periods;

@Repository
public interface PeriodsRepository extends JpaRepository<Periods,Integer> {
}
