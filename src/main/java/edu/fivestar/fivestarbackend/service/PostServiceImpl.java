package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void createPost() {

    }

    @Override
    public void getPosts() {

    }

    @Override
    public void updatePost() {

    }

    @Override
    public void deletePost() {

    }
}
