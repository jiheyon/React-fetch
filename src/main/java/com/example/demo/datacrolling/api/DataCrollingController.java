//package com.example.demo.datacrolling.api;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@Slf4j
//@RequestMapping("/api/datacrollings")
//@RequiredArgsConstructor
//@CrossOrigin        // 다른 서버의 요청 허용
//
//public class DataCrollingController {
//
//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody [???]) {
//
//          log.info("/??? POST request! - {}", newData);
//
//        try {
//            FindAllDTO dto = service.createServ(newData);
//
//            if (dto == null) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok().body(dto);
//
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//
//    }
//
//}
