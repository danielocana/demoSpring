package rancheros.com.spring.configuration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import rancheros.com.application.service.person.*;
import rancheros.com.domain.person.PersonRepository;
import rancheros.com.infrastructure.kafka.RancherosProducer;
import rancheros.com.infrastructure.repository.PersonRepositoryInMemory;
import rancheros.com.infrastructure.repository.PersonRepositoryPostgres;

import javax.persistence.EntityManager;

@EnableBinding(RancherosProducer.class)
public class PersonConfiguration {


    @Bean
    @Profile("test")
    public PersonRepository personRepositoryTest(){
        return new PersonRepositoryInMemory();
    }

    @Bean
    @Profile("dev")
    public PersonRepository personRepository(EntityManager entityManager){
        return new PersonRepositoryPostgres(entityManager);
    }

    @Bean
    public FindAllPersons findAllPersons(PersonRepository repository){
        return new FindAllPersons(repository);
    }

    @Bean
    public FindById findById (PersonRepository repository){
        return new FindById(repository);
    }

    @Bean
    public CreatePerson createPerson (PersonRepository repository, RancherosProducer producer){
        return new CreatePerson(repository, producer);
    }

    @Bean
    public UpdatePerson updatePerson (PersonRepository repository) {
        return new UpdatePerson(repository);
    }
    @Bean
    public DeletePerson deletePerson (PersonRepository repository) {
        return new DeletePerson(repository);
    }
}
