package edu.fivestar.fivestarbackend.controller;

import edu.fivestar.fivestarbackend.dto.UserSignupResDto;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Tag(name = "유저 API")
public class UserController {

    private final UserService userServiceImpl;

    @PostMapping("/users/signup")
    @Operation(summary = "회원 가입")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSignupResDto signUpUser(@RequestBody UserSignupReqDto dto) {
        userServiceImpl.signUpUser(dto);
        return new UserSignupResDto("회원가입 완료");
    }

    
}
