package mihajlo.exampleantony.it;

import mihajlo.exampleantony.it.service.MockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanNightOutApplication {

	@Autowired
	static MockDataService mockDataService;

	public static void main(String[] args) {
		SpringApplication.run(PlanNightOutApplication.class, args);
	}
}
