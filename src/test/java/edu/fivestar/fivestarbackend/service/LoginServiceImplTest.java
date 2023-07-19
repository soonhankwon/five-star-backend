//package edu.fivestar.fivestarbackend.service;
//
//import edu.fivestar.fivestarbackend.domain.User;
//import edu.fivestar.fivestarbackend.dto.LoginReqDto;
//import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
//import edu.fivestar.fivestarbackend.repository.UserRepository;
//import edu.fivestar.fivestarbackend.web.session.SessionConst;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.mock.web.MockHttpServletRequest;
//
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//public class LoginServiceImplTest {
//
//    private LoginService loginService;
//
////    @Mock
//    private UserRepository userRepository;
//
//    private MockHttpServletRequest request;
//
//    @BeforeEach
//    void setUp() {
////        MockitoAnnotations.openMocks(this);
//        loginService = new LoginServiceImpl(userRepository);
//        request = new MockHttpServletRequest();
//    }
//
//    @Test
//    @DisplayName("Successful login")
//    void login_Success() {
//        // Arrange
//        LoginReqDto dto = new LoginReqDto("abc@test.com", "password");
//
//
//        UserSignupReqDto userDto = new UserSignupReqDto(dto.getEmail(),"example",dto.getPassword());
//        User user = new User(userDto);
//
//        // Act
//        loginService.login(dto, request);
//
//        // Assert
//        HttpSession session = request.getSession();
//        assertThat(session.getAttribute(SessionConst.LOGIN_USER)).isEqualTo(user);
//
//    }
//
//}