package rancheros.com.application.service.person;

import rancheros.com.domain.exception.PersonNotFoundException;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

public class DeletePersonUseCase {

    private PersonRepository repository;

    public DeletePersonUseCase(PersonRepository repository) {
        this.repository = repository;
    }

    public void delete(String id) {
        repository.findById(id)
                .flatMap(optional -> {
                    if (optional.isPresent()) {
                        repository.delete(optional.get());
                        return Observable.just(optional.get());
                    } else {
                        throw new PersonNotFoundException(id);
                    }
                }).subscribe();
    }
}
