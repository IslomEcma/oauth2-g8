package ai.ecma.oauth2app.repository;

import ai.ecma.oauth2app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * BY ISLOM UZDEV 12/1/2020 10:05 AM
 */

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
