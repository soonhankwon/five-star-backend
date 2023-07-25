package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.dto.LoginReqDto;
import edu.fivestar.fivestarbackend.dto.LoginResDto;
import edu.fivestar.fivestarbackend.dto.LogoutResDto;
import edu.fivestar.fivestarbackend.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@Tag(name = "유저 로그인 API")
public class LoginController {

    private final LoginService loginServiceImpl;

    @PostMapping("/login")
    @Operation(summary = "로그인 API")
    @ResponseStatus(HttpStatus.OK)
    public LoginResDto login(@Validated @RequestBody LoginReqDto dto, HttpServletRequest request) {
        loginServiceImpl.login(dto, request);
        return new LoginResDto();
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃 API")
    @ResponseStatus(HttpStatus.OK)
    public LogoutResDto logout(HttpServletRequest request) {
        loginServiceImpl.logout(request);
        return new LogoutResDto();
    }

    @GetMapping("/login/check")
    @Operation(summary = "로그인 체크 API")
    @ResponseStatus(HttpStatus.OK)
    public boolean loginCheck(HttpServletRequest request) {
        return loginServiceImpl.loginCheck(request);
    }
}
