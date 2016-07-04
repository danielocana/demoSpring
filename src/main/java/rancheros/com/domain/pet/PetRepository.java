package rancheros.com.domain.pet;

import java.util.List;

/**
 * Created by Daniel on 04/07/2016.
 */
public interface PetRepository {

    List<Pet> findAll();

    Pet findById(String id);

    Pet create(Pet person);
}
