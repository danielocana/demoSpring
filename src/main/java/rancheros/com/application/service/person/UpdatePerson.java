package rancheros.com.application.service.person;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

public class UpdatePerson {

    private PersonRepository repository;

    public UpdatePerson(PersonRepository repository){
        this.repository = repository;
    }

    public Person update (Person person){
        return repository.update(person);
    }
}
