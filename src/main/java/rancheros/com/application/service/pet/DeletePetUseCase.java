package rancheros.com.application.service.pet;

import rancheros.com.domain.pet.PetRepository;

public class DeletePetUseCase {

    private PetRepository repository;

    public DeletePetUseCase (PetRepository repository){
        this.repository = repository;
    }

    public void delete (String id){
        repository.delete(id);
    }
}
