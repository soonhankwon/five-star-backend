package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserSignupReqDtoTest {
    private UserSignupReqDto dto;
    @BeforeEach
    void setup() {
        dto = new UserSignupReqDto("abc@test.com", "test", "1234");
    }
    @Test
    @DisplayName("getter 이메일 테스트")
    void getEmail() {
        assertThat(dto.getEmail()).isEqualTo("abc@test.com");
    }

    @Test
    @DisplayName("getter 이름 테스트")
    void getName() {
        assertThat(dto.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("getter 패스워드 테스트")
    void getPassword() {
        assertThat(dto.getPassword()).isEqualTo("1234");
    }
}