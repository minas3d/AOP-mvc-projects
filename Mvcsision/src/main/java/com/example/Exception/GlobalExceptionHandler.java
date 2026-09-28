package com.example.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlerNotFound(TaskNotFoundException ex , Model model){
        model.addAttribute("Masege ", ex.getMessage());
        return "notFond";
    }

//    @ExceptionHandler(TaskNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleNotFound( TaskNotFoundException ex, HttpServletRequest request)
//    {  ErrorResponse body = new ErrorResponse(
//            404,
//            "Not Found",
//            ex.getMessage(),
//            request.getRequestURI(),
//            Instant.now());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleAny(Exception ex, HttpServletRequest request) {
//        ErrorResponse body = new ErrorResponse(
//                500,
//                "Internal Server Error",
//                ex.getMessage(),
//                request.getRequestURI(),
//                Instant.now());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
//    }
}
