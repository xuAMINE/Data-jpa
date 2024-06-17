package xu.amine.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xu.amine.JPA.model.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
