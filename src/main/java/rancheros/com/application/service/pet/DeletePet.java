package rancheros.com.application.service.pet;

import rancheros.com.domain.pet.PetRepository;

public class DeletePet {

    private PetRepository repository;

    public DeletePet (PetRepository repository){
        this.repository = repository;
    }

    public void delete (String id){
        repository.delete(id);
    }
}
