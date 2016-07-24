package rancheros.com.application.service.pet;


import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;

public class FindByIdPet {

    private PetRepository repository;

    public FindByIdPet (PetRepository repository){
        this.repository = repository;
    }

    public Pet findById(String id){
        return repository.findById(id);
    }
}
