package uz.kpi.motors.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Person;
import uz.kpi.motors.repositories.DepartmentRepository;
import uz.kpi.motors.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    public Department findOne(int id) {
        Optional<Department> foundDepartment = departmentRepository.findById(id);
        return foundDepartment.orElseThrow(PersonNotFoundException::new);
    }
    public void save(Department department){
        departmentRepository.save(department);
    }
}
