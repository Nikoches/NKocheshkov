package Spring_packages;

import Spring_packages.Domains.Message;
import Spring_packages.Repos.MessageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(MessageRepo repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Message("Jack", "Bauer"));
            repository.save(new Message("Chloe", "O'Brian"));
            repository.save(new Message("Kim", "Bauer"));
            repository.save(new Message("David", "Palmer"));
            repository.save(new Message("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Message customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("\n");
            log.info(repository.findByAuthor("Jack").toString());
        };
    }
}