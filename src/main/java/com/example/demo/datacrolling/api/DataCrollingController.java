package com.example.demo.datacrolling.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin        // 다른 서버의 요청 허용

public class DataCrollingController {
}
