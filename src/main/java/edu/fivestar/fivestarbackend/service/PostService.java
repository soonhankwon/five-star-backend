package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.dto.PostCreateReqDto;
import edu.fivestar.fivestarbackend.dto.PostUpdateReqDto;
import edu.fivestar.fivestarbackend.dto.UserPostGetResDto;

import java.util.List;

public interface PostService {

    void createPost(Long userId, PostCreateReqDto dto);
    List<UserPostGetResDto> getPostsByUser(Long userId);
    void updatePost(Long userId, Long postId, PostUpdateReqDto dto);
    void deletePost(Long userId, Long postId);
    UserPostGetResDto getPost(Long postId);
}
