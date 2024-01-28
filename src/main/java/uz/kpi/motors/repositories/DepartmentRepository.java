package uz.kpi.motors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kpi.motors.models.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
