package com.example.demo.user.dto;
// 서버 가입시 필요한 정보
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String email;
    private String password;
    private String username;
}