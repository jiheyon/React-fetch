package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원 가입 기능
    public UserEntity createServ(final UserEntity userEntity) throws RuntimeException {
        if (userEntity == null || userEntity.getEmail() == null) {
            throw new RuntimeException("Invalid args!");
        }

        boolean flag = userRepository.register(userEntity);

        return flag
                ? getByCredential(userEntity.getEmail())
                : null;
    }

    public UserEntity getByCredential(String email) {
        return userRepository.findUserByEmail(email);
    }

    // 로그인 검증 메서드
    // final String email 여기 이메일은 로그인할때 쓴 이메일
    public UserEntity validateLogin(final String email, final String password) {

        // 로그인 검증하려면 1. 회원가입을 했는가?
        UserEntity user = getByCredential(email); // 있으면 정보 옴
        if (user == null) throw new RuntimeException("가입된 회원이 아닙니다.");

        // if문 통과했다면 2. 패스워드가 일치하는가?
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("비밀번호가 틀렸습니다");
        }
        return user; //로그인 성공시 회원정보 리턴
    }
}







