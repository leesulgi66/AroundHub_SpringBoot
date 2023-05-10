package com.example.aroundhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping(value = "hello", method = RequestMethod.GET)  // 고전적인 방법으로 사용하지 않음.
    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }
}
