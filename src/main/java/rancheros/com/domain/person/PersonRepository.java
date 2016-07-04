package rancheros.com.domain.person;

import java.util.List;

import rancheros.com.domain.person.Person;

/**
 * Created by Daniel on 11/06/2016.
 */
public interface PersonRepository {

    List<Person> findAll();

    Person findById(String id);

    Person create(Person person);
}
