package rancheros.com.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import rancheros.com.spring.configuration.PersonConfiguration;
import rancheros.com.spring.configuration.PetConfiguration;
import rancheros.com.spring.configuration.SwaggerConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {PersonConfiguration.class, SwaggerConfiguration.class})
@Import({PetConfiguration.class})
@EnableTransactionManagement
public class DemoApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationTest.class, args);
    }
}
