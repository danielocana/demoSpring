package rancheros.com.domain.pet;

import java.util.List;

public interface PetRepository {

    List<Pet> findAll();

    Pet findById(String id);

    Pet create(Pet person);

    Pet update(Pet pet);
}
