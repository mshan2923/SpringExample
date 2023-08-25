package com.sparta.springmvc.Tutorial_3_response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {
    //Content Type : text/html
    @GetMapping("/json/string")
    @ResponseBody
    public  String helloStringJson()
    {
        return "{\"name\":\"Text\",\"age\":00}}";//Json
    }

    // Content Type : application/json
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson()
    {
        return new Star("Text", -1);//Json타입으로 자동 변환
    }
}
