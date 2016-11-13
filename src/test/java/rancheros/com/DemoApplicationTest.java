package rancheros.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import rancheros.com.spring.DemoApplication;
import rancheros.com.spring.configuration.PersonConfiguration;
import rancheros.com.spring.configuration.PetConfiguration;

@SpringBootApplication
@Import({PersonConfiguration.class, PetConfiguration.class})
public class DemoApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationTest.class, args);
    }
}