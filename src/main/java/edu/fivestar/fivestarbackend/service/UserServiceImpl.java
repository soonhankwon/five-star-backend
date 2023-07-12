package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public void signUpUser(UserSignupReqDto dto) {
        userRepository.save(new User(dto));
    }
}
