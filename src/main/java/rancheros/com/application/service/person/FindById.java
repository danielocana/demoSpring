package rancheros.com.application.service.person;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

/**
 * Created by Daniel on 11/06/2016.
 */
public class FindById {

    private PersonRepository personRepository;

    public FindById(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(String id) {
        return personRepository.findById(id);
    }
}
