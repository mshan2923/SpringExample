package com.sparta.springmvc.Tutorial_3_response;

import lombok.Getter;

@Getter
public class Star {
    String name;
    int age;

    public Star(String name, int age)//필수
    {
        this.name = name;
        this.age = age;
    }

}
