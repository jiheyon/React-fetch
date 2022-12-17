package com.example.demo.user.dto;
//서버가 회원가입 완료하고 서버에 주는 정보들

import com.example.demo.user.entity.UserEntity;
import lombok.*;

@Setter @Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String email;
    private String username;
    private String token; // 인증 토큰

    public UserResponseDTO(UserEntity entity) {
        this.email = entity.getEmail();
        this.username = entity.getUsername();
    }
}