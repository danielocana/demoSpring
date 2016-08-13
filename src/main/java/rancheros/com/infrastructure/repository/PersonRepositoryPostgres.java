package rancheros.com.infrastructure.repository;

import org.springframework.transaction.annotation.Transactional;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Transactional
public class PersonRepositoryPostgres implements PersonRepository {

    private final EntityManager entityManager;

    public PersonRepositoryPostgres(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Observable<Person> findAll() {
        return Observable.from(entityManager.createQuery("SELECT p from " + Person.class.getSimpleName() + " p").getResultList());
    }

    @Override
    public Observable<Optional<Person>> findById(String id) {
        return Observable.create(subscriber -> {
            subscriber.onNext(Optional.ofNullable(entityManager.find(Person.class, id)));
            subscriber.onCompleted();
        });
    }

    @Override
    public Observable<Person> create(Person person) {
        entityManager.persist(person);
        return Observable.just(person);
    }

    @Override
    public Observable<Person> update(Person person) {
        return Observable.create(subscriber -> {
            subscriber.onNext(entityManager.merge(person));
            subscriber.onCompleted();
        });
    }

    @Override
    public void delete(Person person) {
        entityManager.remove(person);
    }
}
