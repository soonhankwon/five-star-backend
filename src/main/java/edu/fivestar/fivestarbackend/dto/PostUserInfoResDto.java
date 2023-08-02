package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "포스트 작성 유저 정보 조회 응답 DTO")
public final class PostUserInfoResDto {

    @Schema(description = "유저 이메일", example = "abcd@naver.com")
    private final String email;

    @Schema(description = "유저 이름", example = "tester")
    private final String name;
}
