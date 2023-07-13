package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.dto.*;
import edu.fivestar.fivestarbackend.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
@Tag(name = "포스팅 관련 API")
public class PostController {

    private final PostService postServiceImpl;

    @PostMapping
    @Operation(summary = "포스트 생성 API")
    @ResponseStatus(HttpStatus.CREATED)
    public PostCreateResDto createPost(@RequestBody PostCreateReqDto dto) {
        postServiceImpl.createPost(dto);
        return new PostCreateResDto();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "유저 포스트 전체 조회 API")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPostGetResDto> getPostsByUser(@PathVariable Long userId) {
        return postServiceImpl.getPostsByUser(userId);
    }

    @GetMapping("/{postId}/detail")
    @Operation(summary = "포스트 상세 조회 API")
    @ResponseStatus(HttpStatus.OK)
    public UserPostGetResDto getPost(@PathVariable Long postId) {
        return postServiceImpl.getPost(postId);
    }

    @PatchMapping("/{userId}/{postId}")
    @Operation(summary = "유저 포스트 수정 API")
    @ResponseStatus(HttpStatus.OK)
    public PostUpdateResDto updatePostByUser(@PathVariable Long userId, @PathVariable Long postId,
                                             @RequestBody PostUpdateReqDto dto) {
        postServiceImpl.updatePost(userId, postId, dto);
        return new PostUpdateResDto();
    }

    @DeleteMapping("/{userId}/{postId}")
    @Operation(summary = "유저 포스트 삭제 API")
    public PostDeleteResDto deletePostByUser(@PathVariable Long userId, @PathVariable Long postId) {
        postServiceImpl.deletePost(userId, postId);
        return new PostDeleteResDto();
    }
}
