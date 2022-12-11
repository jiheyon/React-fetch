package com.example.demo.user.repository;

import com.example.demo.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    // 이메일 주소를 통해 회원정보 조회하기
    UserEntity findUserByEmail(String email);

    // 이메일 주소가 중복인지 조회하기
    boolean existsByEmail(String email);

    // 회원 가입하기
    boolean register(UserEntity entity);

    //아이디찾기, 비번찾기, 등등....
}