package uz.kpi.motors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kpi.motors.models.Metrics;
@Repository
public interface MetricsRepository extends JpaRepository<Metrics,Integer> {
}
