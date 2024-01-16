package com.enjo_eat_spring.enjo_eat_spring.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler {

//    @ExceptionHandler({MyException.class})
//    protected ResponseEntity<Map<String, String>> myExceptionHandler(MyException e) {
//        e.printStackTrace();
//        HttpHeaders responseHeaders = new HttpHeaders();
//        Map<String, String> map = new HashMap<>();
//        map.put("error type", e.getResult());
//        map.put("error code", e.getErrorCode());
//        map.put("message", e.getMessage());
//
//        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
//
//    }
//
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<?> ExceptionHandler(Exception e){
        return new ResponseEntity<>("error", HttpStatus.OK);
    }

}
