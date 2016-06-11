package rancheros.com.application.service.person;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rancheros.com.domain.Person;
import rancheros.com.domain.PersonRepository;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 11/06/2016.
 */
public class FindByIdTest {

    @InjectMocks
    FindById findById;

    @Mock
    PersonRepository repository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void findById() throws Exception {
        Person personMock = new Person("QA","name","firtsname","lastname","dni","phone");

        Mockito.when(repository.findById(Mockito.any(String.class)))
                .then(invocation -> personMock);

        Person result = findById.findById("1");

        Assert.assertThat(result, Matchers.instanceOf(Person.class));

        verify(repository).findById(Mockito.any(String.class));
    }
}