package rancheros.com.domain.pet;

import rx.Observable;

import java.util.Optional;

public interface PetRepository {

    Observable<Pet> findAll(String offset, String limit);

    Optional<Pet> findById(String id);

    Pet createOrUpdate(Pet person);

    void delete(String id);
}
