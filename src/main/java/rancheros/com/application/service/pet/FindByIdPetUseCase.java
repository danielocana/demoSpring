package rancheros.com.application.service.pet;

import rancheros.com.domain.exception.PetNotFoundException;
import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;

import java.util.Optional;

public class FindByIdPetUseCase {

    private PetRepository repository;

    public FindByIdPetUseCase(PetRepository repository){
        this.repository = repository;
    }

    public PetDTO findById(String id){
        return repository.findById(id)
                .map(x -> new PetDTO(x.getId(),x.getName(),x.getType()))
                .orElseThrow(() -> new PetNotFoundException(id));
    }
}