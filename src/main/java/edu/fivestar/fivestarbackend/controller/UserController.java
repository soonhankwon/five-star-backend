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
@RequestMapping("/users")
@Tag(name = "유저 관련 API")
public class UserController {

    private final UserService userServiceImpl;

    @PostMapping("/signup")
    @Operation(summary = "회원 가입 API")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSignupResDto signupUser(@RequestBody UserSignupReqDto dto) {
        userServiceImpl.signupUser(dto);
        return new UserSignupResDto();
    }

    // TODO LOGIN & LOGOUT API

    @DeleteMapping("/resign")
    @Operation(summary = "회원 탈퇴 API")
    @ResponseStatus(HttpStatus.OK)
    public UserResignResDto resignUser(@RequestBody UserResignReqDto dto) {
        userServiceImpl.resignUser(dto);
        return new UserResignResDto();
    }
}
