package rancheros.com.domain.person;

import rx.Observable;
import java.util.Optional;

public interface PersonRepository {

    Observable<Person> findAll();

    Observable<Optional<Person>> findById(String id);

    Observable<Person> create(Person person);

    Observable<Person> update (Person person);

    void delete (Person person);
}
