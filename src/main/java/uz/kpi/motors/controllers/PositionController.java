package uz.kpi.motors.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Person;
import uz.kpi.motors.models.Position;
import uz.kpi.motors.services.PositionService;

import java.util.List;

@Controller
@RequestMapping("/positions")
public class PositionController {
    final private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }


    @GetMapping()
    public String getPositions(Model model){
        model.addAttribute("positions",positionService.findAll());
        return "positions/index";
    }
    @GetMapping("/{id}")
    public Position getPosition(@PathVariable("id") int id){
        return positionService.findOne(id);
    }
    @GetMapping("/new")
    public String newDepartment(@ModelAttribute("position") Position position) {
        return "positions/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("position") Position position) {
        positionService.save(position);
        return "redirect:/positions";
    }

}
