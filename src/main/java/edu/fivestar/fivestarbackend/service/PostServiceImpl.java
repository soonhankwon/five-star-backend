package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.Post;
import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.PostCreateReqDto;
import edu.fivestar.fivestarbackend.dto.PostUpdateReqDto;
import edu.fivestar.fivestarbackend.dto.UserPostGetResDto;
import edu.fivestar.fivestarbackend.repository.PostRepository;
import edu.fivestar.fivestarbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createPost(PostCreateReqDto dto) {
        //TODO Login 구현 후 수정 필요
        User user = userRepository.findUserByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("user email invalid"));
        Post post = new Post(dto, user);
        postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserPostGetResDto> getPostsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user email invalid"));

        return postRepository.findPostsByUser(user)
                .stream()
                .map(Post::createUserPostGetResDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updatePost(Long userId, Long postId, PostUpdateReqDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user email invalid"));

        Post post = postRepository.findPostByUserAndId(user, postId)
                .orElseThrow(() -> new IllegalArgumentException("no post"));

        post.update(dto);
    }

    @Override
    @Transactional
    public void deletePost(Long userId, Long postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("invalid user id"));

        Post post = postRepository.findPostByUserAndId(user, postId)
                .orElseThrow(() -> new IllegalArgumentException("invalid post"));

        postRepository.delete(post);
    }
}
