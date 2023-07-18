package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginResDtoTest {

    @Test
    @DisplayName("DTO 생성 & getter 메세지 검증")
    void getMessage() {
        LoginResDto dto = new LoginResDto();

        assertThat(dto).isNotNull();
        assertThat(dto.getMessage()).isEqualTo("로그인 성공");
    }
}