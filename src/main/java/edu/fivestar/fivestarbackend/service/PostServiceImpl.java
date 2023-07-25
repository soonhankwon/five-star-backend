package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.Post;
import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.PostCreateReqDto;
import edu.fivestar.fivestarbackend.dto.PostUpdateReqDto;
import edu.fivestar.fivestarbackend.dto.UserPostGetResDto;
import edu.fivestar.fivestarbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public void createPost(User loginUser, PostCreateReqDto dto) {
        Post post = new Post(dto, loginUser);
        postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = true)
    public UserPostGetResDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("post id invalid"));
        return post.createUserPostGetResDto();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserPostGetResDto> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable)
                .stream()
                .map(Post::createUserPostGetResDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updatePost(User loginUser, Long postId, PostUpdateReqDto dto) {
        Post post = postRepository.findPostByUserAndId(loginUser, postId)
                .orElseThrow(() -> new IllegalArgumentException("no post"));
        post.update(dto);
    }

    @Override
    @Transactional
    public void deletePost(User loginUser, Long postId) {
        Post post = postRepository.findPostByUserAndId(loginUser, postId)
                .orElseThrow(() -> new IllegalArgumentException("no auth to delete post"));
        postRepository.delete(post);
    }
}
