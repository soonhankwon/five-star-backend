package edu.fivestar.fivestarbackend.repository;

import edu.fivestar.fivestarbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
