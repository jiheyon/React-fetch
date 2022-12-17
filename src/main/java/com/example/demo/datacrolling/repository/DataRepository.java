//ok
package com.example.demo.datacrolling.repository;

import com.example.demo.datacrolling.entity.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface DataRepository {
    boolean save(Data data);
    List<Data> findAll();  // 데이터 목록조회
}
