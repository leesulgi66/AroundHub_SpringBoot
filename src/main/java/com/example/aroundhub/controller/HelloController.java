package com.example.aroundhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping(value = "hello", method = RequestMethod.GET)
    @GetMapping("hello")
    public String hell() {
        return "Hello World";
    }
}
