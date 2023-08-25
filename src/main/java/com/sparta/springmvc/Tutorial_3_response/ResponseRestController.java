package com.sparta.springmvc.Tutorial_3_response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// 데이터 + 뷰 반환 ==> ResponseBody 없어도 오류 안뜸
@RequestMapping("/response/rest")
public class ResponseRestController {
    //Content Type : text/html
    @GetMapping("/json/string")
    public  String helloStringJson()
    {
        return "{\"name\":\"Text\",\"age\":00}}";//Json
    }

    // Content Type : application/json
    @GetMapping("/json/class")
    public Star helloClassJson()
    {
        return new Star("Text", -1);//Json타입으로 자동 변환
    }
}
