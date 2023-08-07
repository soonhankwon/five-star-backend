package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.PostCreateReqDto;
import edu.fivestar.fivestarbackend.dto.PostUpdateReqDto;
import edu.fivestar.fivestarbackend.dto.PostUserInfoResDto;
import edu.fivestar.fivestarbackend.dto.UserPostGetResDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    void createPost(User loginUser, PostCreateReqDto dto);

    List<UserPostGetResDto> getAllPosts(Pageable pageable);

    void updatePost(User loginUser, Long postId, PostUpdateReqDto dto);

    void deletePost(User loginUser, Long postId);

    UserPostGetResDto getPost(Long postId);

    Integer getTotalPostsNumber();

    List<PostUserInfoResDto> getPostsUsersInfo();

    List<UserPostGetResDto> getAllPostsByUsername(String username);
}
