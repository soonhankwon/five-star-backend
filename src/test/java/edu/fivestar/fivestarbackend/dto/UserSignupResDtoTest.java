package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserSignupResDtoTest {

    @Test
    @DisplayName("getter 메세지 테스트")
    void getMessage() {
        UserSignupResDto dto = new UserSignupResDto();
        assertThat(dto.getMessage()).isEqualTo("회원가입 완료");
    }
}