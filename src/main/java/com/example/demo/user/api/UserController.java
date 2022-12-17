package com.example.demo.user.api;

import com.example.demo.security.TokenProvider;
import com.example.demo.user.dto.UserRequestDTO;
import com.example.demo.user.dto.UserResponseDTO;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final TokenProvider provider;

    // 회원 가입 기능
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserRequestDTO reqDto) {

        try {
            // userReqDTO를 서비스에 전송
            // 서비스는 아이디 포함으로 원함
            // 서비스 항목들 userEntity 로 변환해서 사용
            UserEntity entity = new UserEntity(reqDto);
            log.info("/auth/signup POST!! - {}", entity);

            UserEntity user = userService.createServ(entity);

            return ResponseEntity.ok().body(new UserResponseDTO(entity));

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 로그인 요청 처리
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRequestDTO dto) {
        log.info("/auth/signin POST!! =login info : {}", dto);

        try {
            UserEntity user
                    = userService.validateLogin(dto.getEmail(), dto.getPassword());
            // 토큰 생성하기(로그인 성공했으니까)
            //빈 등록된 토큰 TokenProvider 스프링한테 주입받아야 함
            final String token
                    = provider.create(user); // 이 유저 아이디를 식별자로 생성하는 토큰을 발행함

            // UserResponseDTO - 토큰포함 정보를 전달해야됨
            UserResponseDTO responseDTO = new UserResponseDTO(user);
            responseDTO.setToken(token); // 발행한 토큰을 응답정보에 포함

            return ResponseEntity.ok().body(responseDTO);


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 상황에 따라 맞는 에러메세지 보냄
        }
    }
}