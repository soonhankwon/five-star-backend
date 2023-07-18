package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginReqDtoTest {

    @Test
    @DisplayName("DTO 생성 테스트")
    void createDto() {
        LoginReqDto dto = new LoginReqDto("abc@abc.com", "1234");
        assertThat(dto).isNotNull();
    }
}