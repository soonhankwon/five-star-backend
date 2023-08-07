package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.*;
import edu.fivestar.fivestarbackend.service.PostService;
import edu.fivestar.fivestarbackend.web.session.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
@Tag(name = "포스팅 관련 API")
public class PostController {

    private final PostService postServiceImpl;
    private final SessionService sessionService;

    @PostMapping
    @Operation(summary = "포스트 생성 API")
    @ApiResponse(responseCode = "201", description = "포스트 등록 완료")
    @ResponseStatus(HttpStatus.CREATED)
    public GlobalResDto createPost(@RequestBody PostCreateReqDto dto, HttpServletRequest request) {
        User loginUser = sessionService.getLoginUserBySession(request);
        postServiceImpl.createPost(loginUser, dto);
        return new GlobalResDto("포스트 등록 완료");
    }

    @GetMapping
    @Operation(summary = "포스트 전체 조회 API", description = "ex) ?page=0&size=10&sort=id,DESC' => page, size 페이지네이션, sort 정렬이 가능, query param size, sort 생략시 기본값 size 10, sort id,DESC" +
            " : sort 사용 가능 params = user, title")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPostGetResDto> getAllPosts(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return postServiceImpl.getAllPosts(pageable);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "포스트 상세 조회 API")
    @ResponseStatus(HttpStatus.OK)
    public UserPostGetResDto getPost(@PathVariable Long postId) {
        return postServiceImpl.getPost(postId);
    }

    @PatchMapping("/{postId}")
    @Operation(summary = "유저 포스트 수정 API")
    @ApiResponse(responseCode = "200", description = "포스트 수정 완료")
    @ResponseStatus(HttpStatus.OK)
    public GlobalResDto updatePostByUser(@PathVariable Long postId, @RequestBody PostUpdateReqDto dto,
                                         HttpServletRequest request) {
        User loginUser = sessionService.getLoginUserBySession(request);
        postServiceImpl.updatePost(loginUser, postId, dto);
        return new GlobalResDto("포스트 수정 완료");
    }

    @DeleteMapping("/{postId}")
    @Operation(summary = "유저 포스트 삭제 API")
    @ApiResponse(responseCode = "200", description = "포스트 삭제 완료")
    @ResponseStatus(HttpStatus.OK)
    public GlobalResDto deletePostByUser(@PathVariable Long postId, HttpServletRequest request) {
        User loginUser = sessionService.getLoginUserBySession(request);
        postServiceImpl.deletePost(loginUser, postId);
        return new GlobalResDto("포스트 삭제 완료");
    }

    @GetMapping("/total")
    @Operation(summary = "전체 포스트 수 조회 API")
    @ResponseStatus(HttpStatus.OK)
    public GlobalResDto getTotalPostsNumber() {
        Integer total = postServiceImpl.getTotalPostsNumber();
        log.info("total = {}", total);
        return new GlobalResDto(String.valueOf(total));
    }

    @GetMapping("/users/info")
    @Operation(summary = "포스트 작성 유저 정보 조회 API")
    @ResponseStatus(HttpStatus.OK)
    public List<PostUserInfoResDto> getPostsUsersInfo() {
        return postServiceImpl.getPostsUsersInfo();
    }

    @GetMapping("/users")
    @Operation(summary = "포스트 유저 이름으로 조회 API")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPostGetResDto> getAllPostsByUsername(@RequestParam(name = "name") String username) {
        return postServiceImpl.getAllPostsByUsername(username);
    }
}