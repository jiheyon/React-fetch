package com.example.demo.datacrolling.entity;


import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Data {

    private String SiDo; // 시도
    private String SiKunKu; // 시군구
    private String EubMyeonDong; // 읍면동
    private String KyeongDo; // 경도
    private String WiDo; // 위도
    private String KuYeokKuBun; // 구역구분
    private String JangSo; // 장소-위험여부

}