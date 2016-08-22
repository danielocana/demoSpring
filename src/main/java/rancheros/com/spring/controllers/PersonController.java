package rancheros.com.spring.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rancheros.com.application.service.person.*;
import rancheros.com.domain.ErrorMessage;
import rancheros.com.domain.exception.PersonNotFoundException;
import rancheros.com.domain.person.Person;
import rx.exceptions.OnErrorNotImplementedException;
import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private FindAllPersonsUseCase findAllPersonsUseCase;

    private FindByIdPersonUseCase findByIdPersonUseCase;

    private CreatePersonUseCase createPersonUseCase;

    private UpdatePersonUseCase updatePersonUseCase;

    private DeletePersonUseCase deletePersonUseCase;

    @Inject
    public PersonController(FindAllPersonsUseCase findAllPersonsUseCase,
                            FindByIdPersonUseCase findByIdPersonUseCase,
                            CreatePersonUseCase createPersonUseCase,
                            UpdatePersonUseCase updatePersonUseCase,
                            DeletePersonUseCase deletePersonUseCase) {
        this.findAllPersonsUseCase = findAllPersonsUseCase;
        this.findByIdPersonUseCase = findByIdPersonUseCase;
        this.createPersonUseCase = createPersonUseCase;
        this.updatePersonUseCase = updatePersonUseCase;
        this.deletePersonUseCase = deletePersonUseCase;
    }

    @ApiOperation(value = "Listar todas las personas")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Person> findAllPersons(@RequestParam( defaultValue = "0", required=false, name = "offset") String offset,
                                       @RequestParam( defaultValue = "20", required=false, name = "limit") String limit) {
        return findAllPersonsUseCase.findAll(offset, limit).toList().toBlocking().first();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable String id) {
        return findByIdPersonUseCase.findById(id).toBlocking().first();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return createPersonUseCase.createPerson(person).toBlocking().first();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Person update(@RequestBody Person person, @PathVariable String id) {
        person.setId(id);
        return updatePersonUseCase.update(person).toBlocking().first();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        deletePersonUseCase.delete(id).subscribe();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleAllException(Exception ex) {
        if (ex instanceof PersonNotFoundException) {
            PersonNotFoundException exception = (PersonNotFoundException) ex;
            ErrorMessage message = new ErrorMessage(exception.getCode(), exception.getMessage(), exception.getLocalizedMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        if(ex instanceof OnErrorNotImplementedException){
            PersonNotFoundException exception = (PersonNotFoundException) ex.getCause();
            ErrorMessage message = new ErrorMessage(exception.getCode(), exception.getMessage(), exception.getLocalizedMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
