package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "포스팅 성공 응답 DTO")
public final class PostCreateResDto {

    @Schema(description = "포스트 생성 성공 메세지", example = "포스팅 완료")
    private final String message = "포스팅 완료";
}
