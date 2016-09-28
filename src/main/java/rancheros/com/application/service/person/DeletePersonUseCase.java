package rancheros.com.application.service.person;

import rancheros.com.domain.exception.PersonNotFoundException;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

public class DeletePersonUseCase {

    private PersonRepository personRepository;

    public DeletePersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Observable<Void> delete(String id) {
        return personRepository.findById(id)
                .flatMap(personOptional -> personRepository.delete(personOptional.get()))
                .onErrorResumeNext(error -> Observable.error(new PersonNotFoundException(id)));
    }
}