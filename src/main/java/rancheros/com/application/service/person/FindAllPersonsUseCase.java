package rancheros.com.application.service.person;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

public class FindAllPersonsUseCase  {

    private PersonRepository personRepository;

    public FindAllPersonsUseCase(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Observable<Person> findAll (String offset, String limit){
        return personRepository.findAll(offset, limit);
    }
}
