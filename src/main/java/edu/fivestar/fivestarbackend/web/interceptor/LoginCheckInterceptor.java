package edu.fivestar.fivestarbackend.web.interceptor;

import edu.fivestar.fivestarbackend.web.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        if (isPreflightRequest(request)) {
            return true;
        }

        log.info("인증 체크 인터셉터 실행 {}", requestURI);
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
            log.info("미인증 사용자 요청");
            throw new HttpSessionRequiredException("session expired or login plz");
        }
        return true;
    }

    private boolean isPreflightRequest(HttpServletRequest request) {
        return isOptions(request) && hasHeaders(request) && hasMethod(request) && hasOrigin(request);
    }

    private boolean isOptions(HttpServletRequest request) {
        return request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString());
    }

    private boolean hasHeaders(HttpServletRequest request) {
        return Objects.nonNull(request.getHeader("Access-Control-Request-Headers"));
    }

    private boolean hasMethod(HttpServletRequest request) {
        return Objects.nonNull(request.getHeader("Access-Control-Request-Method"));
    }

    private boolean hasOrigin(HttpServletRequest request) {
        return Objects.nonNull(request.getHeader("Origin"));
    }
}
