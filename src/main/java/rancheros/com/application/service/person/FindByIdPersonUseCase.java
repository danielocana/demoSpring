package rancheros.com.application.service.person;

import rancheros.com.domain.exception.PersonNotFoundException;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

public class FindByIdPersonUseCase {

    private PersonRepository personRepository;

    public FindByIdPersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Observable<Person> findById(String id) {
        return personRepository.findById(id)
                .flatMap(person -> Observable.just(person.orElseThrow(()-> new PersonNotFoundException(id))));
    }
}
