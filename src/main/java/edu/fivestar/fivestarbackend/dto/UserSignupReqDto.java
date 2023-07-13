package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "유저 회원가입 요청 DTO")
public final class UserSignupReqDto {

    @Schema(description = "유저 이메일", example = "test@test.com")
    private final String email;

    @Schema(description = "유저 닉네임", example = "tester")
    private final String name;

    @Schema(description = "유저 패스워드", example = "password")
    private final String password;
}
