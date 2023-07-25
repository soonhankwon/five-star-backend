package edu.fivestar.fivestarbackend.web.session;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class SessionService {

    private final UserRepository userRepository;

    @Transactional
    public User getLoginUserBySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new RuntimeException("session invalid");
        }
        User sessionAttributeUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        return getLoginUserByDb(sessionAttributeUser);
    }

    public void expireSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new RuntimeException("session invalid");
        }
        session.invalidate();
    }

    private User getLoginUserByDb(User user) {
        return userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("not exist user in db"));
    }
}
