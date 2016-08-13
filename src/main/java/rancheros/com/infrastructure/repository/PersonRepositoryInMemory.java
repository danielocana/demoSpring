package rancheros.com.infrastructure.repository;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryInMemory implements PersonRepository {

    private List<Person> personList = new ArrayList<>();

    @Override
    public Observable<Person> findAll() {
        return Observable.from(personList);
    }

    @Override
    public Observable<Optional<Person>> findById(String id) {
        return null;
    }

    @Override
    public Observable<Person> create(Person person) {
        return null;
    }

    @Override
    public Observable<Person> update(Person person) {
        return null;
    }

    @Override
    public void delete(Person person) {

    }
}
