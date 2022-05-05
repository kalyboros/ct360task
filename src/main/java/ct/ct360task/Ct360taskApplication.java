package ct.ct360task;

import ct.ct360task.interfaces.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Ct360taskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ct360taskApplication.class, args);
	}

}
