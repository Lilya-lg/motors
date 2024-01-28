package uz.kpi.motors.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Periods;
import uz.kpi.motors.repositories.PeriodsRepository;
import uz.kpi.motors.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeriodsService {
    private final PeriodsRepository periodsRepository;

    public PeriodsService(PeriodsRepository periodsRepository) {
        this.periodsRepository = periodsRepository;
    }


    public List<Periods> findAll(){
        return periodsRepository.findAll();
    }

}
