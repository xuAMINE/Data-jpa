package xu.amine.JPA.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xu.amine.JPA.model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Transactional
    List<Author> findByAgeNamedQuery(@Param("age") int age);

    @Transactional
    @Modifying
    void updateByAgeNamedQuery(@Param("age") int age);

    List<Author> findAllByFirstName(String firstName);

    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    List<Author> findAllByLastNameIn(List<String> lastName);

    List<Author> findAllByAgeBetween(Integer minAge, Integer maxAge);

    List<Author> findAllByAge(Integer age);

    @Transactional
    @Modifying
    @Query("UPDATE Author SET age = :age WHERE id = :id")
    void updateAuthor(int id, int age);


}
