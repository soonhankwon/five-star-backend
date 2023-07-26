package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@Schema(description = "포스트 생성 요청 DTO")
public final class PostCreateReqDto {
    @NotEmpty
    @Schema(description = "포스트 제목", example = "자바란 무엇인가?")
    private final String title;
    @NotEmpty
    @Schema(description = "포스트 내용", example = "객체지향언어이다")
    private final String content;
}
