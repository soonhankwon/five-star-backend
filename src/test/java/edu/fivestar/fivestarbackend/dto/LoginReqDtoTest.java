package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class LoginReqDtoTest {
    private LoginReqDto dto;
    @BeforeEach
    void setup() {
        dto = new LoginReqDto("abc@test.com",  "1234");
    }

    @Test
    @DisplayName("is null test")
    void isNull(){
        assertThat(dto).isNotNull();
    }

    @Test
    @DisplayName("getter 이메일 테스트")
    void getEmail() {
        assertThat(dto.getEmail()).isEqualTo("abc@test.com");
    }

    @Test
    @DisplayName("getter 패스워드 테스트")
    void getPassword() {
        assertThat(dto.getPassword()).isEqualTo("1234");
    }
}