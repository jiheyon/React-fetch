// 요청을 제일 처음 받는곳임, 컨트롤러
// 1.컨트롤러, 2.레파지토리
package com.example.demo.todo.entity.api;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin        // 다른 서버의 요청 허용
public class TodoApiController {

    private final TodoService service;  // API는 TodoService가 있어야 일할수있음, 의존관계

    // 할 일 목록 전체조회 요청
    @GetMapping
    public ResponseEntity<?> todos() {
        log.info("/api/todos GET request!");
        return ResponseEntity.ok().body(service.findAllServ());
    }

    // 할 일 목록 등록 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ToDo newTodo) {

        newTodo.setUserId("noname");
        log.info("/api/todos POST request! - {}", newTodo);

        try {
            FindAllDTO dto = service.createServ(newTodo);

            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    // 할 일 개별 조회 요청
    // URI : /api/todos/3 : GET  => 3번 할 일만 조회해서 클라이언트에게 리턴
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable String id) {
        log.info("/api/todos/{} GET request!", id);

        if (id == null) return ResponseEntity.badRequest().build();

        TodoDto dto = service.findOneServ(id);

        if (dto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dto);
    }


    // 할 일 삭제 요청
    // URI : /api/todos/3 : DELETE
    // => 3번 할 일을 삭제 후 삭제된 이후 갱신된 할일 목록 리턴

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        log.info("/api/todos/{} DELETE request!", id);

        try {
            FindAllDTO dtos = service.deleteServ(id);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    // 할일 수정 요청
    // 새 컨트롤러 만들면 포스트맨으로 확인해보기
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ToDo toDo) {

        log.info("/api/todos PUT request! - {}", toDo);

        try {
            FindAllDTO dtos = service.update(toDo);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}