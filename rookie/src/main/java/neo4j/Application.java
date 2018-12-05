package neo4j;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application {

	private final static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner demo(PersonRepository personRepository) {
		return args -> {
			personRepository.deleteAll();

			Person fukuda = new Person("福田　藍子");
			Person morimoto = new Person("森本　真由");
			Person fukabori = new Person("深堀　駿");

			List<Person> team = Arrays.asList(fukuda, morimoto, fukabori);

			log.info("Before linking up with Neo4j...");

			team.stream().forEach(person -> log.info("\t" + person.toString()));

			personRepository.save(fukuda);
			personRepository.save(morimoto);
			personRepository.save(fukabori);

			fukuda = personRepository.findByName(fukuda.getName());
			fukuda.worksWith(morimoto);
			fukuda.worksWith(fukabori);
			personRepository.save(fukuda);

			morimoto = personRepository.findByName(morimoto.getName());
			morimoto.worksWith(fukabori);

			// We already know that roy works with greg
			personRepository.save(morimoto);

			// We already know craig works with roy and greg

			log.info("Lookup each person by name...");
			team.stream().forEach(person -> log.info(
					"\t" + personRepository.findByName(person.getName()).toString()));

		};
	}

}