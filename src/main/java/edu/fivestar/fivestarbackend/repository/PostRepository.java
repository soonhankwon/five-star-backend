package edu.fivestar.fivestarbackend.repository;

import edu.fivestar.fivestarbackend.domain.Post;
import edu.fivestar.fivestarbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUser(User user);

    Optional<Post> findPostByUserAndId(User user, Long postId);
}
