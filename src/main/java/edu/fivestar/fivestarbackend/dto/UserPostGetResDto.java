package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Schema(description = "유저 포스트 조회 응답 DTO")
public class UserPostGetResDto {

    @Schema(description = "포스트 아이디", example = "1")
    private final Long id;

    @Schema(description = "포스트 제목", example = "협업이란?")
    private final String title;

    @Schema(description = "포스트 내용", example = "바로 이것입니다.")
    private final String content;

    @Schema(description = "포스트 생성일자", example = "2023-07-12T17:56:26.643536")
    private final LocalDateTime createAt;

    @Schema(description = "포스트 수정일자", example = "2023-07-17T17:56:26.643536")
    private final LocalDateTime modifiedAt;

    @Schema(description = "포스트 작성자 이름", example = "Tom")
    private final String author;
}
