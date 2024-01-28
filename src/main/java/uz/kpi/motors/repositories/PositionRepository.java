package uz.kpi.motors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kpi.motors.models.Position;
@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
}
