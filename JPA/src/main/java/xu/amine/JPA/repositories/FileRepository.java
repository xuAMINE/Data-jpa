package xu.amine.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xu.amine.JPA.model.File;

public interface FileRepository extends JpaRepository<File, Integer> {
}
