package com.example.aroundhub.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/exception")
    public void exceptionTest() throws Exception{
        throw new Exception();
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
//        HttpHeaders responseHeaders = new HttpHeaders();
//        //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
//        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//
//        LOGGER.info(e.getLocalizedMessage());
//        LOGGER.info("Controller 내 ExceptionHandler 호출");
//
//        Map<String, String> map = new HashMap<>();
//        map.put("error type", httpStatus.getReasonPhrase());
//        map.put("code:", "400");
//        map.put("message", "에러 발생");
//
//        return new ResponseEntity<>(map, responseHeaders, httpStatus);
//    }
}
