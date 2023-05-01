package com.StudentManagementSystem.khaled.exception.controller;

import com.StudentManagementSystem.khaled.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice
@ControllerAdvice
public class GeneralExceptionController {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> notFound(Exception ex){
        Map <String,String> result = new HashMap<>();
        result.put("any","message");
        return result;
    }
}
