package rancheros.com.application.service.person;

import org.junit.Assert;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.*;

public class UpdatePersonUseCaseTest {

    @InjectMocks
    private UpdatePersonUseCase updatePersonUseCase;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void update() throws Exception {
        Person person = new Person("theId", "theName-updated", "theDNI", "thePhone");

        Mockito.when(personRepository.update(Mockito.any(Person.class)))
                .thenAnswer(invocation -> Observable.just(person));
        TestSubscriber<Person> testSubscriber = new TestSubscriber<>();
        updatePersonUseCase.update(person).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.getOnNextEvents()
                .forEach(person1 -> {
                    Assert.assertEquals(person1.getName(), "theName-updated");
                    Assert.assertThat(person1, samePropertyValuesAs(person));
                });
    }

}