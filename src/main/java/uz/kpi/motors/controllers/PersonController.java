package uz.kpi.motors.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Person;
import uz.kpi.motors.services.PersonService;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {
    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String getPeople(Model model){
        model.addAttribute("people",personService.findAll());
        return "people/index";
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id){
        return personService.findOne(id);
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personService.save(person);
        return "redirect:/people";
    }

}
