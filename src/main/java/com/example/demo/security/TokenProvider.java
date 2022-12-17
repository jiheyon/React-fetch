package com.example.demo.security;


import com.example.demo.user.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@Slf4j
//토큰 발행하는 클래스
public class TokenProvider {

    // 우리 사이트의 서명(랜덤문자열로 만드는데 512바이트 이상으로 만듦)
    // 서명은 바뀌면 안되서 상수로 지정(final)
    private static final String SECRET_KEY
            = "Q4NSl604sgyHJj1qwEkR3ycUeR4uUAt7WJraD7EN3O9DVM4yyYuHxMEbSF4XXyYJkal13eqgB0F7Bq4H";

    // 토큰 발행 메서드
    // 토큰은 수명을 설정해놔야 함
    public String create(UserEntity userEntity) {
        // 기한은 지금부터 1일로 설정
        Date expriyDate = Date.from(
                Instant.now()
                        .plus(1, ChronoUnit.DAYS)   // 최대 유지 기간이 1일
        );

        // Jwt 토큰 생성
        /*         토큰 형태 - 토큰 만료전까지 이 정보 들고다님
            {
                sub: 회원식별자,
                iss: 토큰 발행자 이름 (무슨 앱이 발행했는지),
                iat: 토큰 발행일,
                exp: 토큰 만료일
             } 사이트 서명
         */
        return Jwts.builder()
                //header에 들어갈 내용 및 서명을 위한 SECRET_KEY
                //Hash512코드로 암호화 진행
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS512)
                //payload에 들어갈 내용
                .setSubject(userEntity.getId()) //sub
                .setIssuer("demo app") //iss
                .setIssuedAt(new Date()) // iat
                .setExpiration(expriyDate) // exp
                .compact();
    }

    // 토큰을 디코딩 및 파싱하고 토큰의 위조여부를 확인
    public String validateAndGetUserId(String token) {
        /*
             parseClaimsJws메서드가 Base64로 디코딩 및 파싱
             헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용해 서명한 후
             token의 서명과 비교
             위조되지 않았다면 페이로드(Claims) 리턴, 위조라면 예외를 날림
             그 중 우리는 userId가 필요하므로 getBody를 부름
         */
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))  // 디코딩으로 검수
                .build()
                .parseClaimsJws(token)
                .getBody(); // 정상이면 위의 json정보 줌

        return claims.getSubject(); // 위조면 에러던짐
    }

}
