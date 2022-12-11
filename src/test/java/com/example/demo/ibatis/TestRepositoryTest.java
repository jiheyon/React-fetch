package com.example.demo.ibatis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//junit5
@SpringBootTest
class TestRepositoryTest {

    @Autowired
    TestRepository repository;

    @Test
    @DisplayName("유저이름과 나이가 TBL_TEST테이블에 저장되어야 한다")
    void saveTest() {

        //given:테스트 상황에 주어질 데이터
        TestEntity entity = new TestEntity();
        entity.setUsername("테스트");
        entity.setAge(30);
        // when: 실제 테스트 실행
        boolean flag = repository.save(entity);

        // then: 테스트 결과 단언
        assertTrue(flag);
        assertNotNull(entity.getId());
    }

    @Test
    @DisplayName("유저이름과 나이를 수정해야 한다.")
    void modifyTest() {
        //given
        TestEntity entity = new TestEntity();
        entity.setUsername("수정수정");
        entity.setAge(25);
        entity.setId("d280b239-8c69-4b86-ad38-992a4bad87d7");
        //when
        boolean flag = repository.modify(entity);

        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("유저이름과 나이를 수정해야 한다.")
    @Transactional
    @Rollback
    void deleteTest() {
        //given
        String id = "d335e973-62d7-49a6-9cfb-42dd165e5017";

        //when
        boolean flag = repository.remove(id);

        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("테스트 데이터 전체를 조회해야 한다.")
    void findAllTest() {
        //given
        //when
        List<TestEntity> entityList = repository.findAll();

        //then
        System.out.println(entityList);
        assertEquals(2, entityList.size());
    }

}