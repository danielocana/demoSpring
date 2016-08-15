package rancheros.com.application.service.person;

import org.springframework.integration.support.MessageBuilder;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rancheros.com.infrastructure.kafka.RancherosProducer;
import rx.Observable;

import java.util.UUID;

public class CreatePersonUseCase {

    private PersonRepository personRepository;
    private RancherosProducer producer;

    public CreatePersonUseCase(PersonRepository personRepository, RancherosProducer producer) {
        this.personRepository = personRepository;
        this.producer = producer;
    }

    public Observable<Person> createPerson(Person person){
        person.setId(UUID.randomUUID().toString());
        //Send message to kafka
        //TODO what happens if I send message to kafka and the repository give me an error
        producer.getMessageChannel().send(MessageBuilder.withPayload(person).build());
        return personRepository.create(person);
    }
}
