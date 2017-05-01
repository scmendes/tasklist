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
			// save a couple of tasks
			repository.save(new Tasklist("daily meeting", "diariamente as 09:15 hrs"));
			repository.save(new Tasklist("sprint planning", "terça-feira 14:00 as 16:00 hrs"));
			repository.save(new Tasklist("retrospectiva", "quarta-feira 11:00 as 12:00 hrs"));
			repository.save(new Tasklist("1:1", "mensalmente"));

			// fetch all customers
			log.info("found with findAll():");
			log.info("-------------------------------");
			for (Tasklist item : repository.findAll()) {
				log.info(item.toString());
			}
			log.info("");

			// fetch an individual by ID
			Tasklist item = repository.findOne(1L);
			log.info("Task found with findOne(1L):");
			log.info("--------------------------------");
			log.info(item.toString());
			log.info("");

		};
	}    

}
