package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.GlobalResDto;
import edu.fivestar.fivestarbackend.dto.UserResignReqDto;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.service.UserService;
import edu.fivestar.fivestarbackend.web.session.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Tag(name = "유저 관련 API")
public class UserController {

    private final UserService userServiceImpl;
    private final SessionService sessionService;

    @PostMapping("/signup")
    @Operation(summary = "회원 가입 API")
    @ApiResponse(responseCode = "201", description = "회원 가입 완료")
    @ResponseStatus(HttpStatus.CREATED)
    public GlobalResDto signupUser(@Validated @RequestBody UserSignupReqDto dto) {
        userServiceImpl.signupUser(dto);
        log.info("signup: email{} name{}",dto.getEmail(),dto.getName());
        return new GlobalResDto("회원 가입 완료");
    }



    @DeleteMapping("/resign")
    @Operation(summary = "회원 탈퇴 API")
    @ApiResponse(responseCode = "200", description = "회원 탈퇴 완료")
    @ResponseStatus(HttpStatus.OK)
    public GlobalResDto resignUser(@RequestBody UserResignReqDto dto, HttpServletRequest request) {
        User loginUser = sessionService.getLoginUserBySession(request);
        userServiceImpl.resignUser(dto, loginUser);
        sessionService.expireSession(request);
        return new GlobalResDto("회원 탈퇴 완료");
    }
}