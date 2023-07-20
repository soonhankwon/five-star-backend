package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.LoginReqDto;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.repository.UserRepository;
import edu.fivestar.fivestarbackend.service.LoginService;
import edu.fivestar.fivestarbackend.service.LoginServiceImpl;
import edu.fivestar.fivestarbackend.web.session.SessionConst;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginServiceImplTest {

    private LoginService loginService;

    @Mock
    private UserRepository userRepository;

    private MockHttpServletRequest request;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        loginService = new LoginServiceImpl(userRepository);
        request = new MockHttpServletRequest();

    }

    @Test
    public void testLogin_ValidCredentials() {
        // Arrange
        LoginReqDto dto = new LoginReqDto("example@example.com", "password");
        UserSignupReqDto Udto = new UserSignupReqDto("example@example.com","exname","password");
        User loginUser = new User(Udto);
        when(userRepository.findUserByEmailAndPassword(dto.getEmail(), dto.getPassword()))
                .thenReturn(Optional.of(loginUser));

        // Act
        loginService.login(dto, request);

        // Assert
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        assertThat(loggedInUser).isNotNull();
        assertThat(loginUser).isEqualTo(loggedInUser);
//        verify(userRepository, times(1)).findUserByEmailAndPassword(dto.getEmail(), dto.getPassword());
    }

    @Test
    public void testLogin_InvalidCredentials() {
        // Arrange
        LoginReqDto dto = new LoginReqDto("example@example.com", "wrongpassword");
        when(userRepository.findUserByEmailAndPassword(dto.getEmail(), dto.getPassword()))
                .thenReturn(Optional.empty());

        // Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> loginService.login(dto, request));
        assertThat(exception.getMessage()).isEqualTo("email or password invalid");
        verify(userRepository, times(1)).findUserByEmailAndPassword(dto.getEmail(), dto.getPassword());
    }

    @Test
    public void testLogout() {
        // Arrange
        HttpSession session = request.getSession();
        UserSignupReqDto Udto = new UserSignupReqDto("example@example.com","exname","password");
        User loginUser = new User(Udto);
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);

        // Act
        loginService.logout(request);
        System.out.println((request.isRequestedSessionIdValid()));
        // Assert
        assertThat(request.isRequestedSessionIdValid()).isFalse();
        verify(session, times(1)).invalidate();
    }
}