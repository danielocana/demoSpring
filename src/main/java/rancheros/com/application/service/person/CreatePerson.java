package rancheros.com.application.service.person;

import rancheros.com.domain.Person;
import rancheros.com.domain.PersonRepository;

/**
 * Created by Daniel on 11/06/2016.
 */
public class CreatePerson {

    private PersonRepository personRepository;

    public CreatePerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person){
        return personRepository.create(person);
    }
}
