package rancheros.com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import rancheros.com.spring.configuration.PersonConfiguration;
import rancheros.com.spring.configuration.PetConfiguration;

@SpringBootApplication
@EnableEurekaClient
@Import({PersonConfiguration.class, PetConfiguration.class})
@EntityScan("rancheros.com")
@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
