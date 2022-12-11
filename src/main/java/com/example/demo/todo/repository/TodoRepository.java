package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  // 꼭 붙이기
// 역할: 할 일 데이터를 CRUD한다(생성, 조회, 수정, 삭제)
public interface TodoRepository {

    // 할일 생성 기능, 명세만 한다

    /**
     * 할 일 데이터를 저장소에 저장하는 기능
     * @param todo - 할 일 데이터의 집합
     * @return - 저장 성공시 true, 실패 시 false 반환
     */
    boolean save(ToDo todo);

    // 할일 목록조회 기능
    List<ToDo> findAll();

    // 할일 개별조회 기능
    ToDo findOne(String  id);

    // 할일 삭제 기능
    boolean remove(String  id);

    // 할 일 수정기능(체크기능,  제목 수정기능)
    boolean modify(ToDo toDo); // 수정할 ToDo 요청
    // xml열어서 sql쓰러 가야됨

}
