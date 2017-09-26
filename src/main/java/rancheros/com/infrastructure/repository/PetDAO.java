package rancheros.com.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rancheros.com.domain.pet.Pet;

public interface PetDAO extends JpaRepository<Pet, String> {
}
