package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.UserResignReqDto;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void signupUser(UserSignupReqDto dto) {
        userRepository.save(new User(dto));
    }

    @Override
    @Transactional
    public void resignUser(UserResignReqDto dto) {
        User user = userRepository.findUserByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException());
        userRepository.delete(user);
    }
}
