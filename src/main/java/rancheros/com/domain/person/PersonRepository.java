package rancheros.com.domain.person;

import java.util.List;

/**
 * Created by Daniel on 11/06/2016.
 */
public interface PersonRepository {

    List findAll();

    Person findById(String id);

    Person create(Person person);

    Person update (Person person);
}
