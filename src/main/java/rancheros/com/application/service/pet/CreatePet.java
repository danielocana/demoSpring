package rancheros.com.application.service.pet;

import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;

public class CreatePet {

    private PetRepository repository;

    public CreatePet(PetRepository repository){
        this.repository = repository;
    }

    public Pet insert(Pet pet){
        return repository.create(pet);
    }
}
