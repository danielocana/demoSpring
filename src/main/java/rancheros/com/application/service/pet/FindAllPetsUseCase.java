package rancheros.com.application.service.pet;

import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;
import rx.Observable;

import java.util.List;

public class FindAllPetsUseCase {

    private PetRepository repository;

    public FindAllPetsUseCase(PetRepository repository) {
        this.repository = repository;
    }

    public Observable<Pet> findAll (String offset, String limit){
        return repository.findAll(offset, limit);
    }
}
