package com.sparta.springmvc.Tutorial_4_request;

import com.sparta.springmvc.Tutorial_3_response.Star;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")//중괄호가 파라미터 취급
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)//GetMapping의 이름 그대로
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }//주소창에 정보 노출 + '/' 으로 구분

    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    //@RequestParam 생략가능
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam(required = false) int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }//주소창에 정보 노출 + 쿼리문(? 변수=정보&변수=정보) 으로 구분 + 흔히 많이씀
    //required 는 기본값 true , false면 입력 안할시 null 을 받지만 오류(주의) X


    // [Request sample]
    // POST http://localhost:8080/hello/request/form/param
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    // html 부분에서 From 태그 필요 , 아마?
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }//주소창에 안보임



    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.getName(), star.getAge());
    }

    // [Request sample]
    // POST http://localhost:8080/hello/request/form/model
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(Star star) {// @ModelAttribute 생략 가능 / 생략시 단순값타입이면 RequestParam
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.getName(), star.getAge());
    }//객체로 Post / 클라이언트 부분과 이름 동일하게 (직렬화로 통신하니까)
    //  ***** Star에 파라미터 없는 생성자 만드니까 기본값으로 클라가 받음  + 게터 쓰라면서 안씀!


    // [Request sample]
    // POST http://localhost:8080/hello/request/form/json
    // Header
    //  Content type: application/json
    // Body
    //  {"name":"Robbie","age":"95"}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.getName(), star.getAge());
    }// HTTP 에서 Json 방식으로 넘어 왔을때 @RequestBody 꼭 넣어 줘야함

}
