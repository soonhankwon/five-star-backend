package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.dto.UserResignReqDto;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;

public interface UserService {
    void signupUser(UserSignupReqDto dto);

    void resignUser(UserResignReqDto dto);
}
