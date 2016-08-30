package rancheros.com.spring.controllers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rancheros.com.aplication.DemoApplicationTest;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import javax.inject.Inject;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplicationTest.class)
@WebAppConfiguration
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforePetTestRun.sql")
public class PetControllerTest {

    private MockMvc mockMvc;

    @Inject
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp () throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Ignore
    public void findAllPetsTest() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pets");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    @Ignore
    public void findByIdTest() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pets/1");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}