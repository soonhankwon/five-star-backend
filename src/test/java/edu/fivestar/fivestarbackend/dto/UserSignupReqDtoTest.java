package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserSignupReqDtoTest {

    @Test
    @DisplayName("getter 이메일 테스트")
    void getEmail() {
        UserSignupReqDto dto = new UserSignupReqDto("abc@test.com", "test", "1234");
        assertThat(dto.getEmail()).isEqualTo("abc@test.com");
    }

    @Test
    @DisplayName("getter 이름 테스트")
    void getName() {
        UserSignupReqDto dto = new UserSignupReqDto("abc@test.com", "test", "1234");
        assertThat(dto.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("getter 패스워드 테스트")
    void getPassword() {
        UserSignupReqDto dto = new UserSignupReqDto("abc@test.com", "test", "1234");
        assertThat(dto.getPassword()).isEqualTo("1234");
    }
}