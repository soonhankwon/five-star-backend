package edu.fivestar.fivestarbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateReqDto {

    private final String email;
    private final String title;
    private final String content;
}
