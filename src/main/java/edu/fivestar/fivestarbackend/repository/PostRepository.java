package edu.fivestar.fivestarbackend.repository;

import edu.fivestar.fivestarbackend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Long, Post> {
}
