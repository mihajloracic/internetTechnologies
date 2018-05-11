package mihajlo.exampleantony.it;

import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.Role;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.UserRepository;
import mihajlo.exampleantony.it.service.MockDataService;
import mihajlo.exampleantony.it.service.StorageService;
import mihajlo.exampleantony.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootApplication
public class PlanNightOutApplication implements CommandLineRunner {

	@Autowired
	static MockDataService mockDataService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(PlanNightOutApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
		//Setup a default user if db is empty
		if (repository.findByUsername("user") == null)
			service.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
	}
	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetail(repository.findByUsername(username));
	}

}
