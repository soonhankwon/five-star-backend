package edu.fivestar.fivestarbackend.service;

import edu.fivestar.fivestarbackend.domain.User;
import edu.fivestar.fivestarbackend.dto.UserResignReqDto;
import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void signupUser(UserSignupReqDto dto) {
        if(userRepository.existsUserByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("already exist email");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());
        userRepository.save(new User(new UserSignupReqDto(dto.getEmail(), dto.getName(), encodedPassword)));
    }

    @Override
    @Transactional
    public void resignUser(UserResignReqDto dto, User loginUser) {
        log.info("resign ={}", loginUser);
        if (bCryptPasswordEncoder.matches(dto.getPassword(), loginUser.getPassword()))
            userRepository.delete(loginUser);
        else
            throw new IllegalArgumentException("password invalid");
    }
}
