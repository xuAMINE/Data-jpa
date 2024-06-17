package xu.amine.JPA;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xu.amine.JPA.model.Author;
import xu.amine.JPA.model.File;
import xu.amine.JPA.repositories.AuthorRepository;
import xu.amine.JPA.repositories.FileRepository;
import xu.amine.JPA.repositories.VideoRepository;

import java.time.LocalDate;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			AuthorRepository ar,
			FileRepository fr
	) {
		return args -> {
			for (int i = 0; i < 30; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 69))
						.email(faker.name().username() + "@xuamine.com")
						.build();
				ar.save(author);
			}

//			ar.updateAuthor(1, 99);
 			var authors = ar.findByAgeNamedQuery(50);
			authors.forEach(System.out::println);

			ar.updateByAgeNamedQuery(24);
		};

	}

}
