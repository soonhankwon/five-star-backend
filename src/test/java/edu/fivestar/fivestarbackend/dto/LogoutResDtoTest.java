package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LogoutResDtoTest {

    @Test
    @DisplayName("DTO 생성 & getter 메세지 검증")
    void createDto() {
        LogoutResDto dto = new LogoutResDto();

        assertThat(dto).isNotNull();
        assertThat(dto.getMessage()).isEqualTo("로그아웃 성공");
    }
}