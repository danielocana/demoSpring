package rancheros.com.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import rancheros.com.application.service.pet.FindAllPets;
import rancheros.com.domain.pet.PetRepository;
import rancheros.com.infrastructure.repository.PetsJDBCRepositoryPostgres;

/**
 * Created by Daniel on 04/07/2016.
 */
public class PetConfiguration {

    @Bean
    @Profile("dev")
    public PetRepository petRepository (JdbcTemplate jdbcTemplate){
        return new PetsJDBCRepositoryPostgres(jdbcTemplate);
    }

    @Bean
    public FindAllPets findAllPets(PetRepository repository){
        return new FindAllPets(repository);
    }
}
