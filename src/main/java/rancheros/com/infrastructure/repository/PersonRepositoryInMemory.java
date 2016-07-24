package rancheros.com.infrastructure.repository;

import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryInMemory implements PersonRepository {

    private List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public Person findById(String id) {
        return null;
    }

    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }
}
