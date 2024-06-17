package xu.amine.JPA.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQueries(
        {
            @NamedQuery(
                    name = "Author.findByAgeNamedQuery",
                    query = "SELECT a FROM Author a WHERE a.age >= :age"
            ),
            @NamedQuery(
                    name = "Author.updateByAgeNamedQuery",
                    query = "UPDATE Author a SET a.age = :age"
            )
        }
)

public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;

    @ManyToMany(
            mappedBy = "authors",
            fetch = FetchType.EAGER
    )
    private List<Course> courses;

}
