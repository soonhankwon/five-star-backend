package edu.fivestar.fivestarbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostCreateResDtoTest {

    @Test
    void getMessage() {
        PostCreateResDto dto = new PostCreateResDto();
        assertThat(dto).isNotNull();
        assertThat(dto.getMessage()).isEqualTo("포스팅 완료");

    }
}