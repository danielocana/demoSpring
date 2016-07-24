package rancheros.com.spring.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rancheros.com.application.service.person.CreatePerson;
import rancheros.com.application.service.person.FindAllPersons;
import rancheros.com.application.service.person.FindById;
import rancheros.com.application.service.person.UpdatePerson;
import rancheros.com.domain.ErrorMessage;
import rancheros.com.domain.person.Person;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private FindAllPersons findAllPersons;

    private FindById findById;

    private CreatePerson createPerson;

    private UpdatePerson updatePerson;

    @Inject
    public PersonController(FindAllPersons findAllPersons, FindById findById, CreatePerson createPerson, UpdatePerson updatePerson) {
        this.findAllPersons = findAllPersons;
        this.findById = findById;
        this.createPerson = createPerson;
        this.updatePerson = updatePerson;
    }

    @ApiOperation(value = "Listar todas las personas")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
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

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Person update (@RequestBody Person person, @PathVariable String id) {
        person.setId(id);
        return updatePerson.update(person);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.CONFLICT)
    public ErrorMessage handleAllException(Exception ex) {
        return new ErrorMessage("235",ex.getMessage(),ex.getLocalizedMessage());
    }
}
