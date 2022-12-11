package com.example.demo.ibatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  // 이 인터페이스의 의존성을 마이바티스에게 위임하겠다는 소리임
public interface TestRepository {
    // SQL에서 TBL_TEST로 만들었음


    // 데이터 저장기능
    boolean save(TestEntity entity); // 저장 후 성공 실패를 알려주니까 불린

    // 데이터 수정 기능
    boolean modify(TestEntity entity);

    // 데이터 삭제 기능
    boolean remove(String id);  // 하나만 찝어야되늒 PK값으로

    // 데이터 전체조회 기능
    List<TestEntity> findAll(); // 목록을 조회하고 그 목록엔 데스트 어쩌구가 써있음
}
