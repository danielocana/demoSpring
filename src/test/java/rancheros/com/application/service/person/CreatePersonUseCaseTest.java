package rancheros.com.application.service.person;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;
import rx.Observable;
import rx.observers.TestSubscriber;
import testcategories.UnitaryTest;

@Category(UnitaryTest.class)
public class CreatePersonUseCaseTest {

    @InjectMocks
    private CreatePersonUseCase createPersonUseCase;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    //TODO I need to mock kafka messaging, line 21 in the use case.
    public void createPerson() throws Exception {
        Person person = new Person("theId", "theName", "theDNI", "thePhone");

        Mockito.when(personRepository.create(Mockito.any(Person.class)))
                .thenAnswer(invocation -> Observable.just(person));

        TestSubscriber<Person> testSubscriber = new TestSubscriber<>();

        createPersonUseCase.createPerson(person).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
    }
}