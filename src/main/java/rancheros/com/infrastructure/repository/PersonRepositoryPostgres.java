package rancheros.com.infrastructure.repository;

import org.springframework.transaction.annotation.Transactional;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;
import rx.Observer;

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
    public Observable<Person> findAll(String offset, String limit) {
        return Observable.from(entityManager.createQuery("SELECT p from " + Person.class.getSimpleName() + " p")
                .setFirstResult(Integer.parseInt(offset))
                .setMaxResults(Integer.parseInt(limit))
                .getResultList());
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
        Person result = entityManager.merge(person);
        return Observable.create(subscriber -> {
            subscriber.onNext(result);
            subscriber.onCompleted();
        });
    }

    @Override
    public Observable<Void> delete(Person person) {
        entityManager.remove(person);
        return Observable.create(Observer::onCompleted);
    }
}
