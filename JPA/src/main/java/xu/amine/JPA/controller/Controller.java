package xu.amine.JPA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xu.amine.JPA.model.Author;
import xu.amine.JPA.repositories.AuthorRepository;

import java.util.List;

@RequestMapping("adaka")
@RestController
public class Controller {

    AuthorRepository authorRepository;

    public Controller(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/sayina")
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @GetMapping("sayina/{firstName}")
    public List<Author> getByFirstName(@PathVariable("firstName") String firstName) {
        return authorRepository.findAllByFirstName(firstName);
    }

    @GetMapping("sayina/{minAge}-{maxAge}")
    public List<Author> getByAge(@PathVariable("minAge") int minAge, @PathVariable("maxAge") int maxAge) {
        return authorRepository.findAllByAgeBetween(minAge, maxAge);
    }

    @GetMapping("/{age}")
    public List<Author> getByAge(@PathVariable int age) {
        return authorRepository.findAllByAge(age);
    }
}
