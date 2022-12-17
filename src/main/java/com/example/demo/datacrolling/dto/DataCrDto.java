//// this 참조안됨
//package com.example.demo.datacrolling.dto;
//
//import lombok.*;
//
//@Setter @Getter @ToString
//@NoArgsConstructor
//@AllArgsConstructor
//public class DataCrDto {
//
//    private String SiDo; // 시도
//    private String SiKunKu; // 시군구
//    private String EubMyeonDong; // 읍면동
//    private String KyeongDo; // 경도
//    private String WiDo; // 위도
//    private String KuYeokKuBun; // 구역구분
//    private String JangSo; // 장소-위험여부
//
//    // Data에서 DataCrdto가 필요한 필드를 빼오는 생성자
//    public DataCrDto (Data daTa) {
//        this.SiDo = daTa.getSiDo();
//        this.SiKunKu = daTa.getSiKunKu();
//        this.EubMyeonDong = daTa.EubMyeonDong();
//        this.WiDo = daTa.WiDo();
//        this.KuYeokKuBun = daTa.KuYeokKuBun();
//        this.JangSo = daTa.JangSo();
//
//    }
//}
