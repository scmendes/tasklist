package org.smendes.tasklist;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smendes.tasklist.entity.Tasklist;
import org.smendes.tasklist.repository.TasklistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        System.out.println("Inspect the beans provided:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
    
	@Bean
	public CommandLineRunner demo(TasklistRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Tasklist("Jack", "Bauer", null));
			repository.save(new Tasklist("Chloe", "O'Brian", null));
			repository.save(new Tasklist("Kim", "Bauer", null));
			repository.save(new Tasklist("David", "Palmer", null));
			repository.save(new Tasklist("Michelle", "Dessler", null));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Tasklist customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Tasklist customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Tasklist bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}    

}
