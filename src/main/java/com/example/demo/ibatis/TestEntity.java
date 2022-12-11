package com.example.demo.ibatis;

import lombok.*;

import java.util.UUID;

@Setter @Getter @ToString
@AllArgsConstructor
public class TestEntity {  // Entity 클래스 스펙은 DB랑 동일하게 진행함

    private String id;
    private String username;
    private int age;

    public TestEntity() {
        this.id = UUID.randomUUID().toString();   // 유일한 1개로 지정
    }
}