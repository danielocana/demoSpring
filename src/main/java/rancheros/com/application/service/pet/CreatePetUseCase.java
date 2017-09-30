package rancheros.com.application.service.pet;

import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;

public class CreatePetUseCase {

    private PetRepository repository;

    public CreatePetUseCase(PetRepository repository){
        this.repository = repository;
    }

    public Pet insert(Pet pet){
        return repository.createOrUpdate(pet);
    }
}
