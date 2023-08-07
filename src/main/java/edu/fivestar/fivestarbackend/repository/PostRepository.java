package edu.fivestar.fivestarbackend.repository;

import edu.fivestar.fivestarbackend.domain.Post;
import edu.fivestar.fivestarbackend.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(attributePaths = {"user"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select p from Post p left join p.user")
    Page<Post> findAll(Pageable pageable);

    Optional<Post> findPostByUserAndId(User user, Long postId);

    @Query("SELECT p FROM Post p WHERE p.id IN (select min (p2.id) from Post p2 GROUP BY p2.user.id)")
    List<Post> findSinglePostPerUser();

    List<Post> findPostsByUser(User user);
}
