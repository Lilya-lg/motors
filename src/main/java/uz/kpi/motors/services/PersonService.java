package uz.kpi.motors.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.kpi.motors.models.Person;
import uz.kpi.motors.models.Position;
import uz.kpi.motors.repositories.PersonRepository;
import uz.kpi.motors.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> findAll(){
        return personRepository.findAll();
    }
    public Person findOne(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);
    }
    public void save(Person person){
        personRepository.save(person);
    }
}
