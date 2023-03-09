package aord.repository;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aord.model.JWT;

@Repository
public interface JWTRepository extends JpaRepository<JWT, Long> {
	Optional<JWT> findByValueAndExpirationTimeGreaterThanEqual(String value, Instant date);

}
