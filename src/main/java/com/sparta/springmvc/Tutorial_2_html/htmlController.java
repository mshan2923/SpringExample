package com.sparta.springmvc.Tutorial_2_html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class htmlController {
    private static long visitCount = 0;
    @GetMapping("/static/hello")
    public String hello(){
        return "hello.html";
    }// [resourcrs/templates]에서 "hello.html" 찾아서 오류뜸
    @GetMapping("/html/redirect")
    public String htmlStatic(Object obj) {
        return "redirect:/hello.html";
    }//리다이렉트 해서 접근
    @GetMapping("/html/templates")
    public  String htmlTemplates(){
        return "hello";
    }// [ .html ] 생략가능


    @GetMapping("/html/dynamic")
    public  String htmlDynamic(Model model)
    {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }//Model타입이 String 과 Lombok 이랑 충돌 (import org.springframework.ui.Model; 사용)
}
