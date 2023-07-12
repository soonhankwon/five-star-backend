package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "유저 포스트 삭제 응답 DTO")
public final class PostDeleteResDto {

    @Schema(description = "포스트 삭제 성공 메세지", example = "포스트 삭제 완료")
    private final String message = "포스트 삭제 완료";
}
