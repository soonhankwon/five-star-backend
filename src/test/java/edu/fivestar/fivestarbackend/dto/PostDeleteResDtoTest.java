package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostDeleteResDtoTest {
    @Test
    void getMessage() {
        PostDeleteResDto dto = new PostDeleteResDto();
        assertThat(dto).isNotNull();
        assertThat(dto.getMessage()).isEqualTo("포스팅 완료");

    }
}