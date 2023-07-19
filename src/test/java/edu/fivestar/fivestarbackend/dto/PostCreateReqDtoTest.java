package edu.fivestar.fivestarbackend.dto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PostCreateReqDtoTest {
    private PostCreateReqDto dto;

    @BeforeEach
    void setup() {
        dto =new PostCreateReqDto("자바란","이것입니다.");
    }
    @Test
    @DisplayName("is null test")
    void isNull(){
        assertThat(dto).isNotNull();
    }

    @Test
    @DisplayName("getter title 테스트")
    void getTitle() {
        assertThat(dto.getTitle()).isEqualTo("자바란");
    }

    @Test
    @DisplayName("getter Content 테스트")
    void getContent() {
        assertThat(dto.getContent()).isEqualTo("이것입니다.");
    }



}