package rancheros.com.application.service.person;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

public class DeletePerson {

    private PersonRepository repository;

    public DeletePerson (PersonRepository repository){
        this.repository = repository;
    }

    public void delete(String id){
        Person person = repository.findById(id);
        repository.delete(person);
    }
}
