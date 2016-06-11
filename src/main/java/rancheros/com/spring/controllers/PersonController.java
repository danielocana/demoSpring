package rancheros.com.spring.controllers;

import org.springframework.web.bind.annotation.*;
import rancheros.com.application.service.person.CreatePerson;
import rancheros.com.application.service.person.FindAllPersons;
import rancheros.com.application.service.person.FindById;
import rancheros.com.domain.Person;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Daniel on 11/06/2016.
 */

@RestController
@RequestMapping("/persons")
public class PersonController {

    private FindAllPersons findAllPersons;

    private FindById findById;

    private CreatePerson createPerson;

    @Inject
    public PersonController(FindAllPersons findAllPersons, FindById findById, CreatePerson createPerson) {
        this.findAllPersons = findAllPersons;
        this.findById = findById;
        this.createPerson = createPerson;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findAllPersons (){
        return findAllPersons.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable String id){
        return findById.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person create (@RequestBody Person person){
        return createPerson.createPerson(person);
    }
}
