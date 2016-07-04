package rancheros.com.infrastructure.repository;

import org.springframework.transaction.annotation.Transactional;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

/**
 * Created by Daniel on 11/06/2016.
 */
@Transactional
public class PersonRepositoryPostgres implements PersonRepository {

    private final EntityManager entityManager;

    public PersonRepositoryPostgres(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p from " + Person.class.getSimpleName() + " p").getResultList();
    }

    @Override
    public Person findById(String id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public Person create(Person person) {
        String id = UUID.randomUUID().toString();
        person.setId(id);
        entityManager.persist(person);
        return person;
    }
}
