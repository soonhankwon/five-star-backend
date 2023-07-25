package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.dto.LoginReqDto;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    void login(LoginReqDto dto, HttpServletRequest request);

    void logout(HttpServletRequest request);

    boolean loginCheck(HttpServletRequest request);
}
