package com.internship.trueclub.exception;

import com.internship.trueclub.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
ResponseEntity<ApiResponse> exceptionHandler(ResourceNotFoundException ex){
    ApiResponse response = ApiResponse.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
}
}
