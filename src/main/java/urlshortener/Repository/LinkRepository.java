package urlshortener.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import urlshortener.entities.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long>{

	Optional<Link> findByIdentificationCode(String identificationCode);
	
}
