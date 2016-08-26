package rancheros.com.application.service.person;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Optional;

public class DeletePersonUseCaseTest {

    @InjectMocks
    private DeletePersonUseCase deletePersonUseCase;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void delete() throws Exception {
        Person person = new Person("theId", "theName-updated", "theDNI", "thePhone");

        Mockito.when(personRepository.findById(Mockito.anyString()))
                .thenAnswer(invocation -> Observable.just(Optional.of(person)));

        Mockito.when(personRepository.delete(Mockito.any(Person.class)))
                .thenAnswer(invocation -> Observable.empty());
        TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
        deletePersonUseCase.delete("1").subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertNoValues();
    }

}