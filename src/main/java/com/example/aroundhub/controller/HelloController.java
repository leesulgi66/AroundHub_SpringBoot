package com.example.aroundhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    //@RequestMapping(value = "hello", method = RequestMethod.GET)  // 고전적인 방법으로 사용하지 않음.
    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("log-test")
    public void logTest(){

        LOGGER.trace("Trace Log");
        LOGGER.debug("debug Log");
        LOGGER.info("info Log");
        LOGGER.warn("warn Log");
        LOGGER.error("error Log");
    }
}
