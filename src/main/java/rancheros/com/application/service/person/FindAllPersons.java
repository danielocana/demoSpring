package rancheros.com.application.service.person;

import rancheros.com.domain.Person;
import rancheros.com.domain.PersonRepository;

import java.util.List;

/**
 * Created by Daniel on 11/06/2016.
 */
public class FindAllPersons {

    private PersonRepository personRepository;

    public FindAllPersons(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll (){
        return personRepository.findAll();
    }
}
