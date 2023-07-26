package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@Schema(description = "유저 회원가입 요청 DTO")
public final class UserSignupReqDto {

    @Email(regexp = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+$")
    @NotBlank
    @Length(min = 5,max = 320)
    @Schema(description = "유저 이메일", example = "abc@test.com")
    private final String email;

    @NotEmpty
    @Length(min = 2,max = 20)
    @Schema(description = "유저 닉네임", example = "test")
    private final String name;

    @NotBlank
    @Length(min = 4,max = 20)
    @Schema(description = "유저 패스워드", example = "1234")
    private final String password;


}
