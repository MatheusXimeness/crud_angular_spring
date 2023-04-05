package com.matheus.controller;

import com.matheus.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Essa classe garante que mandaremos para o usário a menor mensagem possível, para que não haja
// vulnerabilidade de segurança
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class) // qual é o tipo de excessão que esse método vai lidar
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException( RecordNotFoundException ex ) {
        return ex.getMessage();
    }
}
