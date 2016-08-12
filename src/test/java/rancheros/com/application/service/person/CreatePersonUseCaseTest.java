package rancheros.com.application.service.person;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rancheros.com.domain.person.Person;
import rancheros.com.domain.person.PersonRepository;

public class CreatePersonUseCaseTest {

    @InjectMocks
    private CreatePersonUseCase createPersonUseCase;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPerson() throws Exception {
    }
}