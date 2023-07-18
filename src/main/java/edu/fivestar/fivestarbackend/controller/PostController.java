package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.*;
import edu.fivestar.fivestarbackend.service.PostService;
import edu.fivestar.fivestarbackend.web.session.SessionConst;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
@Tag(name = "포스팅 관련 API")
public class PostController {

    private final PostService postServiceImpl;

    @PostMapping
    @Operation(summary = "포스트 생성 API")
    @ResponseStatus(HttpStatus.CREATED)
    public PostCreateResDto createPost(@RequestBody PostCreateReqDto dto, HttpServletRequest request) {
//        User loginUser = getLoginUserBySession(request);
        UserSignupReqDto userDto = new UserSignupReqDto("abc", "abc", "abc");
        User loginUser = new User(userDto);
        postServiceImpl.createPost(loginUser, dto);
        return new PostCreateResDto();
    }

    @GetMapping
    @Operation(summary = "유저 포스트 전체 조회 API", description = "ex) ?page=0&size=10&sort=id,DESC' => page, size 페이지네이션, sort 정렬이 가능, query param size, sort 생략시 기본값 size 10, sort id,DESC")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPostGetResDto> getPostsByUser(HttpServletRequest request,
                                                  @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        User loginUser = getLoginUserBySession(request);
        return postServiceImpl.getPostsByUser(loginUser, pageable);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "포스트 상세 조회 API")
    @ResponseStatus(HttpStatus.OK)
    public UserPostGetResDto getPost(@PathVariable Long postId) {
        return postServiceImpl.getPost(postId);
    }

    @PatchMapping("/{postId}")
    @Operation(summary = "유저 포스트 수정 API")
    @ResponseStatus(HttpStatus.OK)
    public PostUpdateResDto updatePostByUser(@PathVariable Long postId, @RequestBody PostUpdateReqDto dto,
                                             HttpServletRequest request) {
        User loginUser = getLoginUserBySession(request);
        postServiceImpl.updatePost(loginUser, postId, dto);
        return new PostUpdateResDto();
    }

    @DeleteMapping("/{postId}")
    @Operation(summary = "유저 포스트 삭제 API")
    @ResponseStatus(HttpStatus.OK)
    public PostDeleteResDto deletePostByUser(@PathVariable Long postId, HttpServletRequest request) {
        User loginUser = getLoginUserBySession(request);
        postServiceImpl.deletePost(loginUser, postId);
        return new PostDeleteResDto();
    }

    private User getLoginUserBySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        if (loginUser == null) {
            throw new RuntimeException("session disconnected");
        }
        return loginUser;
    }
}
