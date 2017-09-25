package rancheros.com.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import rancheros.com.application.service.pet.*;
import rancheros.com.domain.pet.PetRepository;
import rancheros.com.infrastructure.repository.PetsJDBCRepositoryPostgres;

public class PetConfiguration {

    @Bean
    public PetRepository petRepository (JdbcTemplate jdbcTemplate){
        return new PetsJDBCRepositoryPostgres(jdbcTemplate);
    }

    @Bean
    public FindAllPetsUseCase findAllPets(PetRepository repository){
        return new FindAllPetsUseCase(repository);
    }

    @Bean
    public FindByIdPetUseCase findByIdPet (PetRepository repository){
        return new FindByIdPetUseCase(repository);
    }

    @Bean
    public CreatePetUseCase createPet (PetRepository repository){
        return new CreatePetUseCase(repository);
    }

    @Bean
    public UpdatePetUseCase updatePet (PetRepository repository){
        return new UpdatePetUseCase(repository);
    }

    @Bean
    public DeletePetUseCase deletePet (PetRepository repository){
        return new DeletePetUseCase(repository);
    }
}
