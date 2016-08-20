package rancheros.com.application.service.person;

import rancheros.com.domain.exception.PersonNotFoundException;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

public class DeletePersonUseCase {

    private PersonRepository repository;

    public DeletePersonUseCase(PersonRepository repository) {
        this.repository = repository;
    }

    public Observable<Void> delete(String id) {
        return Observable.defer(() -> repository.findById(id)
                .flatMap(personOptional -> {
                    if (personOptional.isPresent()) {
                        return repository.delete(personOptional.get());
                    } else {
                        throw new PersonNotFoundException(id);
                    }
                })
                .flatMap(person -> Observable.empty()));
    }
}