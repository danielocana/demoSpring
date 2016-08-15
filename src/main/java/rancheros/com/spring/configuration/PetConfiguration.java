package rancheros.com.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
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
    public FindAllPets findAllPets(PetRepository repository){
        return new FindAllPets(repository);
    }

    @Bean
    public FindByIdPet findByIdPet (PetRepository repository){
        return new FindByIdPet(repository);
    }

    @Bean
    public CreatePet createPet (PetRepository repository){
        return new CreatePet(repository);
    }

    @Bean
    public UpdatePet updatePet (PetRepository repository){
        return new UpdatePet(repository);
    }

    @Bean
    public DeletePet deletePet (PetRepository repository){
        return new DeletePet(repository);
    }
}
