package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "포스트 생성 요청 DTO")
public class PostCreateReqDto {

    @Schema(description = "포스트 제목", example = "제목입니다")
    private final String title;

    @Schema(description = "포스트 내용", example = "내용입니다")
    private final String content;
}
