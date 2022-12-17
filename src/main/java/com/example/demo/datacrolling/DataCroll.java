//package com.example.demo.datacrolling;
//
//import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//public class DataCroll {
//
//    @PutMapping("/test")
//    public String puttest(@RequestBody String jsonData) {
//        JSONArray jsonArray = new JSONArray(jsonData);
//        JSONObject jsonObject = null;
//        String name = null;
//        String hobby = null;
//
//        try {
//            for (int i = 0; i < jsonArray.leng; i++) {
//                jsonObject = jsonArray.getJSONObject(i);
//
//                if (jsonObject.isNull("name")) { // name을 검색했는데 null이 아니면
//                    System.out.println("-------------------------------------");
//                    System.out.println(jsonObject.getJSONObject("commons"));
//                    // 위에 보이는 commons를 json객체로 다시 받아서 데이터를 뽑아낸다.
//                    jsonObject = jsonObject.getJSONObject("commons");
//                    System.out.println("commons data : " + jsonObject.get("나이"));
//                    System.out.println("commons data : " + jsonObject.get("동아리"));
//                    System.out.println("commons data : " + jsonObject.get("학교"));
//
//                } else {
//                    System.out.println("-------------------------------------");
//                    name = String.valueOf(jsonObject.get("name"));
//                    hobby = String.valueOf(jsonObject.get("hobby"));
//                    System.out.println("JSON " + i + "번째 데이터");
//                    System.out.printf("name : %s, hobby : %s\n", name, hobby);
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject response = new JSONObject();
//
//        response.put("1번째 데이터", "프로그래밍");
//        response.put("2번째 데이터", "너무");
//        response.put("3번째 데이터", "재밌쥬?");
//        System.out.println(response.toString());
//        return response.toString();
//    }
//}
