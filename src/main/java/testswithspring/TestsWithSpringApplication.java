package testswithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@ComponentScan(basePackages = {"testswithspring"})
//@EnableAutoConfiguration
public class TestsWithSpringApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(TestsWithSpringApplication.class, args);
		UserController userController = applicationContext.getBean(UserController.class);
		userController.justry();
	}

}
