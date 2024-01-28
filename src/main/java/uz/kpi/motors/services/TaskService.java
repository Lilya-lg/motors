package uz.kpi.motors.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Periods;
import uz.kpi.motors.models.Task;
import uz.kpi.motors.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    public List<Task> findByPeriod(Periods period){
        return taskRepository.findByPeriod(period);
    }
    public List<Task> findByPeriodAndDepartment(Periods period,Department department){

        return taskRepository.findByPeriodAndDepartment(period,department);
    }
    public List<Task> findByDepatment(Department department){
        return taskRepository.findByDepartment(department);
    }
    public void save(Task task, Department department){
        task.setDepartment(department);
        taskRepository.save(task);
    }
    public void update(Task task, Task updatedT){
        updatedT.setPerson(task.getPerson());
        updatedT.setResult(task.getResult());
        taskRepository.save(updatedT);
    }
    public Task findOne(int id) {
        Optional<Task> foundTask = taskRepository.findById(id);
        return foundTask.orElse(null);
    }
    public void setMaxWeight(){
        for(Task task:findAll()){
            task.setMaxW();
        }
    }


}
