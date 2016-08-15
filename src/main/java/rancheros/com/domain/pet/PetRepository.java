package rancheros.com.domain.pet;

import rx.Observable;

public interface PetRepository {

    Observable<Pet> findAll();

    Pet findById(String id);

    Pet create(Pet person);

    Pet update(Pet pet);

    void delete(String id);
}
