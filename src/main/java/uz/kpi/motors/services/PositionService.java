package uz.kpi.motors.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.kpi.motors.models.Department;
import uz.kpi.motors.models.Person;
import uz.kpi.motors.models.Position;
import uz.kpi.motors.repositories.PositionRepository;
import uz.kpi.motors.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    public List<Position> findAll(){
        return positionRepository.findAll();
    }
    public Position findOne(int id) {
        Optional<Position> foundPosition = positionRepository.findById(id);
        return foundPosition.orElseThrow(PersonNotFoundException::new);
    }
    public void save(Position position){
        positionRepository.save(position);
    }
}
