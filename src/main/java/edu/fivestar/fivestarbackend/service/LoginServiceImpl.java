package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.LoginReqDto;
import edu.fivestar.fivestarbackend.repository.UserRepository;
import edu.fivestar.fivestarbackend.web.session.SessionConst;
import edu.fivestar.fivestarbackend.web.session.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final SessionService sessionService;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public void login(LoginReqDto dto, HttpServletRequest request) {
        User loginUser = userRepository.findUserByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("not exist user email"));

        if (!bCryptPasswordEncoder.matches(dto.getPassword(), loginUser.getPassword())) {
            throw new IllegalArgumentException("password invalid");
        }
        HttpSession session = request.getSession();
        log.info("login {}", loginUser);
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
    }

    @Override
    public void logout(HttpServletRequest request) {
        sessionService.expireSession(request);
    }

    @Override
    public boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null;
    }
}
