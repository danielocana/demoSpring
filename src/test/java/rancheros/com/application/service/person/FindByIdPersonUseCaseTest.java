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

        Mockito.when(personRepository.findById(Mockito.any(String.class)))
                .thenAnswer(invocation -> person);

        Person response = findByIdPersonUseCase.findById("id");

        Assert.assertEquals(response.getName(), "theName");
        Assert.assertThat(response, samePropertyValuesAs(person));
    }

}