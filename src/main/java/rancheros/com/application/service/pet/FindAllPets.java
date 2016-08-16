package rancheros.com.application.service.pet;

import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;
import rx.Observable;

import java.util.List;

public class FindAllPets {

    private PetRepository repository;

    public FindAllPets(PetRepository repository) {
        this.repository = repository;
    }

    public Observable<Pet> findAll (String offset, String limit){
        return repository.findAll(offset, limit);
    }
}
