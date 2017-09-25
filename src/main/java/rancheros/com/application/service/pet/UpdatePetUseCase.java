package rancheros.com.application.service.pet;

import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;

public class UpdatePetUseCase {

    private PetRepository repository;

    public UpdatePetUseCase(PetRepository repository){
        this.repository = repository;
    }

    public Pet update (Pet pet){
        return repository.update(pet);
    }
}
