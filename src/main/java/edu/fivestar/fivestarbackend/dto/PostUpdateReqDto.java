package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "포스트 업데이트 REQUEST DTO")
public class PostUpdateReqDto {

    private String title;
    private String content;
}
