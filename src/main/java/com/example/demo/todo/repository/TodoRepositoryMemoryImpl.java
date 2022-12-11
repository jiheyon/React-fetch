//package com.example.demo.todo.repository;
//
//
//import com.example.demo.todo.entity.ToDo;
//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//// 역할: 할 일 데이터를 메모리에 CRUD하는 역할
////메모리에 저장 안하고 디비에 저장하려고 주석처리
////@Repository
//
//@Mapper  // 이거 쓰고 [package com.example.demo.todo.repository;] 이 경로로 폴더 만들기!-데이터 연동
//public class TodoRepositoryMemoryImpl implements TodoRepository {
//
////    메모리 저장소
//    /**
//     * key: 할 일의 식별 id값
//     * value: 할 일 집합객체
//     */
//    private static final Map<String, ToDo> toDoMap = new HashMap<>();
//
//    static {
////        toDoMap.put(1L, new ToDo("저녁밥 만들기"));
////        toDoMap.put(2L, new ToDo("산책가기"));
////        toDoMap.put(3L, new ToDo("노래연습하기"));
////        toDoMap.put(4L, new ToDo("리엑트 컴포넌트 만들기"));
//    }
//
//
//    @Override
//    public boolean save(ToDo todo) {
//        if (todo == null) return false;
//
//        toDoMap.put(todo.getId(), todo);
//        return true;
//    }
//
//    @Override
//    public List<ToDo> findAll() {
//
//        List<ToDo> toDoList = new ArrayList<>();
//        for (String id : toDoMap.keySet()) {
//            ToDo toDo = toDoMap.get(id);
//            toDoList.add(toDo);
//        }
//        return toDoList;
//    }
//
//    @Override
//    public ToDo findOne(String id) {
//        return toDoMap.get(id);
//    }
//
//    @Override
//    public boolean remove(String id) {
//        ToDo todo = toDoMap.remove(id);
//        return todo != null;
//    }
//}
