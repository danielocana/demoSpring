package rancheros.com.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import rancheros.com.application.service.person.CreatePerson;
import rancheros.com.application.service.person.FindAllPersons;
import rancheros.com.application.service.person.FindById;
import rancheros.com.domain.person.PersonRepository;
import rancheros.com.infrastructure.repository.PersonRepositoryInMemory;
import rancheros.com.infrastructure.repository.PersonRepositoryPostgres;

import javax.persistence.EntityManager;

/**
 * Created by Daniel on 11/06/2016.
 */
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
    public CreatePerson createPerson (PersonRepository repository){
        return new CreatePerson(repository);
    }
}
