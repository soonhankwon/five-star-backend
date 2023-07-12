package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.dto.UserResignReqDto;
import edu.fivestar.fivestarbackend.dto.UserResignResDto;
import edu.fivestar.fivestarbackend.dto.UserSignupResDto;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Tag(name = "유저 API")
public class UserController {

    private final UserService userServiceImpl;

    @PostMapping("/users/signup")
    @Operation(summary = "회원 가입")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSignupResDto signupUser(@RequestBody UserSignupReqDto dto) {
        userServiceImpl.signupUser(dto);
        return new UserSignupResDto("회원가입 완료");
    }

    // TODO LOGIN API

    @DeleteMapping("/users/resign")
    @Operation(summary = "회원 탈퇴")
    @ResponseStatus(HttpStatus.OK)
    public UserResignResDto resignUser(@RequestBody UserResignReqDto dto) {
        userServiceImpl.resignUser(dto);
        return new UserResignResDto("회원탈퇴 완료");
    }
}
