package rancheros.com.application.service.person;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

public class FindByIdPersonUseCase {

    private PersonRepository personRepository;

    public FindByIdPersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(String id) {
        return personRepository.findById(id);
    }
}
