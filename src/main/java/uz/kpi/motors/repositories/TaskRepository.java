package uz.kpi.motors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Periods;
import uz.kpi.motors.models.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByPeriod(Periods period);
    List<Task> findByPeriodAndDepartment(Periods period, Department department);
    List<Task> findByDepartment(Department department);

}
