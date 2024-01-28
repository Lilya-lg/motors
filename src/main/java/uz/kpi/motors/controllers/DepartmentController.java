package uz.kpi.motors.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Person;
import uz.kpi.motors.services.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    final private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping()
    public String  getDepartments(Model model){
        model.addAttribute("departments",departmentService.findAll());
        return "departments/index";

    }
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") int id){
        return departmentService.findOne(id);
    }
    @GetMapping("/new")
    public String newDepartment(@ModelAttribute("department") Department department) {
        return "departments/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        return "redirect:/departments";
    }

}
