package rancheros.com.application.service.person;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

public class CreatePerson {

    private PersonRepository personRepository;

    public CreatePerson(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person){
        return personRepository.create(person);
    }
}
