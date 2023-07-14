package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@Schema(description = "로그인 요청 DTO")
public final class LoginReqDto {

    @NotEmpty
    private final String email;

    @NotEmpty
    private final String password;
}
