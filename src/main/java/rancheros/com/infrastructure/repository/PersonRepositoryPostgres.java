package rancheros.com.infrastructure.repository;

import org.springframework.transaction.annotation.Transactional;
import rancheros.com.domain.exception.PersonNotFoundException;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Transactional
public class PersonRepositoryPostgres implements PersonRepository {

    private final EntityManager entityManager;

    public PersonRepositoryPostgres(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p from " + Person.class.getSimpleName() + " p").getResultList();
    }

    @Override
    public Person findById(String id) {
        Person person = entityManager.find(Person.class, id);
        if(person != null) {
            return person;
        }
        throw new PersonNotFoundException(id);
    }

    @Override
    public Person create(Person person) {
        String id = UUID.randomUUID().toString();
        person.setId(id);
        entityManager.persist(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        return entityManager.merge(person);
    }

    @Override
    public void delete(Person person) {
        entityManager.remove(person);
    }
}
