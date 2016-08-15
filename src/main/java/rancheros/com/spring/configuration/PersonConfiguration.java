package rancheros.com.spring.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import rancheros.com.application.service.person.*;
import rancheros.com.domain.person.PersonRepository;
import rancheros.com.infrastructure.kafka.RancherosProducer;
import rancheros.com.infrastructure.repository.PersonRepositoryPostgres;

import javax.persistence.EntityManager;

@EnableBinding(RancherosProducer.class)
public class PersonConfiguration {

    @Bean
    public PersonRepository personRepository(EntityManager entityManager){
        return new PersonRepositoryPostgres(entityManager);
    }

    @Bean
    public FindAllPersonsUseCase findAllPersons(PersonRepository repository){
        return new FindAllPersonsUseCase(repository);
    }

    @Bean
    public FindByIdPersonUseCase findById (PersonRepository repository){
        return new FindByIdPersonUseCase(repository);
    }

    @Bean
    public CreatePersonUseCase createPerson (PersonRepository repository, RancherosProducer producer){
        return new CreatePersonUseCase(repository, producer);
    }

    @Bean
    public UpdatePersonUseCase updatePerson (PersonRepository repository) {
        return new UpdatePersonUseCase(repository);
    }
    @Bean
    public DeletePersonUseCase deletePerson (PersonRepository repository) {
        return new DeletePersonUseCase(repository);
    }
}
