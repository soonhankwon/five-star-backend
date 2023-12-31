package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "유저 탈퇴 요청 DTO")
public final class UserResignReqDto {

    @NotEmpty
    @Schema(description = "유저 패스워드", example = "password123")
    private String password;
}
