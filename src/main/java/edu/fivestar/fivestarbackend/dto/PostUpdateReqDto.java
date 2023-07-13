package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "포스트 업데이트 요청 DTO")
public class PostUpdateReqDto {

    @Schema(description = "포스트 제목", example = "새로운 제목")
    private String title;

    @Schema(description = "포스트 내용", example = "새로운 내용")
    private String content;
}
