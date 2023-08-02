package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.dto.GlobalResDto;
import edu.fivestar.fivestarbackend.dto.LoginReqDto;
import edu.fivestar.fivestarbackend.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @ApiResponse(responseCode = "200", description = "로그인 완료")
    @ResponseStatus(HttpStatus.OK)
    public GlobalResDto login(@Validated @RequestBody LoginReqDto dto, HttpServletRequest request) {
        loginServiceImpl.login(dto, request);
        return new GlobalResDto("로그인 완료");
    }

    @PostMapping("/logout")
    @Operation(summary = "로그아웃 API")
    @ApiResponse(responseCode = "200", description = "로그아웃 완료")
    @ResponseStatus(HttpStatus.OK)
    public GlobalResDto logout(HttpServletRequest request) {
        loginServiceImpl.logout(request);
        return new GlobalResDto("로그아웃 완료");
    }

    @GetMapping("/login/check")
    @Operation(summary = "로그인 체크 API")
    @ResponseStatus(HttpStatus.OK)
    public boolean loginCheck(HttpServletRequest request) {
        return loginServiceImpl.loginCheck(request);
    }
}
