package rancheros.com.application.service.person;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

public class UpdatePersonUseCase {

    private PersonRepository repository;

    public UpdatePersonUseCase(PersonRepository repository){
        this.repository = repository;
    }

    public Observable<Person> update (Person person){
        return repository.update(person);
    }
}
