package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@Schema(description = "유저 회원가입 요청 DTO")
public final class UserSignupReqDto {

    @NotEmpty
    @Schema(description = "유저 이메일", example = "abc@test.com")
    private final String email;

    @NotEmpty
    @Schema(description = "유저 닉네임", example = "test")
    private final String name;

    @NotEmpty
    @Schema(description = "유저 패스워드", example = "1234")
    private final String password;
}
