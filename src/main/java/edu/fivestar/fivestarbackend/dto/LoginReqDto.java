package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@Schema(description = "로그인 요청 DTO")
public final class LoginReqDto {

    @NotBlank
    @Email
    @Schema(description = "이메일", example = "abc@test.com")
    private final String email;

    @NotBlank
    @Schema(description = "패스워드", example = "1234")
    private final String password;
}
