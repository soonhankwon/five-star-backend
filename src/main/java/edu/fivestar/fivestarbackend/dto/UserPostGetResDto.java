package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Schema(description = "유저 포스트 조회 응답 DTO")
public class UserPostGetResDto {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;
}
