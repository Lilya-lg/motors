package uz.kpi.motors.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.kpi.motors.models.Periods;
import uz.kpi.motors.models.Person;
import uz.kpi.motors.models.Task;
import uz.kpi.motors.security.AuthProviderImpl;
import uz.kpi.motors.security.PersonDetails;
import uz.kpi.motors.services.MetricsService;
import uz.kpi.motors.services.PeriodsService;
import uz.kpi.motors.services.PersonService;
import uz.kpi.motors.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    final private TaskService taskService;
    final private PeriodsService periodsService;
    final private PersonService personService;
    final private MetricsService metricsService;


    public TaskController(TaskService taskService, PeriodsService periodsService, PersonService personService, MetricsService metricsService) {
        this.taskService = taskService;
        this.periodsService = periodsService;
        this.personService = personService;
        this.metricsService = metricsService;

    }
    @GetMapping()
    public String  getTasks(Model model){
        model.addAttribute("periods",periodsService.findAll());
      return "tasks/index";
    }
    @PostMapping("/show")
    public String findTasks(Model model,@ModelAttribute("period") Periods period){
        int counter = 0;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
        Person person = personDetails.getPerson();
        taskService.setMaxWeight();
        model.addAttribute("tasks",taskService.findByPeriodAndDepartment(period,person.getDepartment()));
        model.addAttribute("counter",counter);
       // model.addAttribute("periods",periodsService.findAll());
        return "tasks/show";
    }
    @GetMapping("/new")
    public String newTask(Model model,@ModelAttribute("task") Task task) {
        model.addAttribute("people",personService.findAll());
        model.addAttribute("metricslar",metricsService.findAll());
        model.addAttribute("periods",periodsService.findAll());
        return "tasks/new";
    }
    @GetMapping("/plan")
    public String plan(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
        Person person = personDetails.getPerson();
        model.addAttribute("tasks",taskService.findByDepatment(person.getDepartment()));
        return "tasks/showAll";
    }
    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("task",taskService.findOne(id));
        model.addAttribute("people",personService.findAll());
        model.addAttribute("metricslar",metricsService.findAll());
        return "tasks/edit";
    }
    @PostMapping()
    public String create(@ModelAttribute("task") Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
        Person person = personDetails.getPerson();
        taskService.save(task,person.getDepartment());
        return "redirect:/tasks";
    }
    @PostMapping("/{id}/edit")
    public String updateTask(@ModelAttribute("task") Task task,@PathVariable("id") int id){
        taskService.update(task,taskService.findOne(id));
        return "redirect:/tasks";
    }



}
