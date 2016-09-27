package rancheros.com.application.service.person;

import org.junit.Before;
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

import java.util.ArrayList;
import java.util.List;

@Category(UnitaryTest.class)
public class FindAllPersonsUseCaseTest {

    @InjectMocks
    private FindAllPersonsUseCase findAllPersonsUseCase;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() throws Exception {
        Person person1 = new Person("theId", "theName", "theDNI", "thePhone");
        Person person2 = new Person("theId", "theName", "theDNI", "thePhone");
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        Mockito.when(personRepository.findAll(Mockito.anyString(),Mockito.anyString()))
                .thenAnswer(invocation -> Observable.from(persons));
        TestSubscriber<Person> testSubscriber = new TestSubscriber<>();
        findAllPersonsUseCase.findAll("0","20").subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(2);
    }

}