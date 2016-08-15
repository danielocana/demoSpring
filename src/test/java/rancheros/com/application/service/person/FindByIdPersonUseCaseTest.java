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

import java.util.Optional;

import static org.hamcrest.Matchers.samePropertyValuesAs;

public class FindByIdPersonUseCaseTest {

    @InjectMocks
    private FindByIdPersonUseCase findByIdPersonUseCase;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findById() throws Exception {
        Person person = new Person("theId", "theName", "theDNI", "thePhone");

        Mockito.when(personRepository.findById(Mockito.anyString()))
                .thenAnswer(invocation -> Observable.just(Optional.of(person)));

        TestSubscriber<Person> testSubscriber = new TestSubscriber<>();

        findByIdPersonUseCase.findById("id").subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
        testSubscriber.getOnNextEvents()
                .forEach(person1 -> {
                    Assert.assertEquals(person1.getName(), "theName");
                    Assert.assertThat(person1, samePropertyValuesAs(person));
                });
    }

}