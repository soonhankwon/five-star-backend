package edu.fivestar.fivestarbackend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserResignReqDtoTest {

    @Test
    @DisplayName("getter 패스워드 테스트")
    void getPassword() {
        UserResignReqDto dto = new UserResignReqDto("1234");
        assertThat(dto).isNotNull();
        assertThat(dto.getPassword()).isEqualTo("1234");
    }
}