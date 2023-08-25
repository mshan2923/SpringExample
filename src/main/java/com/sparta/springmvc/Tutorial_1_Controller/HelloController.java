package com.sparta.springmvc.Tutorial_1_Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// @~~~ 을 애너테이션 이라 부름
@RequestMapping("/api")//클래스안 메소드 경로의 기본값 재정의
@Controller//전에 이거 없어서 안된듯
public class HelloController {
    @GetMapping("/hello")// 클라 호출경로는 '/api/hello'
    @ResponseBody//리턴이 단순 문자열 이여서 (Controller가 뷰 반환 하는데 , 이걸로 값 반환 한다고 알림)
    public String hello()
    {
        return "Hello World!";
    }
    @PostMapping("/hello")
    @ResponseBody
    public String helloPost()
    {
        return "Hell o World";
    }
    @GetMapping("/get")
    @ResponseBody//리턴이 단순 문자열 이여서
    public String get()
    {
        return "GET Method 요청";
    }
    @PostMapping("/post")
    @ResponseBody//리턴이 단순 문자열 이여서
    public String post()
    {
        return "POST Method 요청";
    }
    @PutMapping("/put")
    @ResponseBody//리턴이 단순 문자열 이여서
    public String put()
    {
        return "Put Method 요청";
    }
    @DeleteMapping("/delete")
    @ResponseBody//리턴이 단순 문자열 이여서
    public String delete()
    {
        return "Delete Method 요청";
    }
}
