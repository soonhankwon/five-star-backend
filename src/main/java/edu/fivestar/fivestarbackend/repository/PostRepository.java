package edu.fivestar.fivestarbackend.repository;

import edu.fivestar.fivestarbackend.domain.Post;
import edu.fivestar.fivestarbackend.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Page<Post> findAll(Pageable pageable);

    Optional<Post> findPostByUserAndId(User user, Long postId);
}
