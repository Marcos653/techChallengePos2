package com.techchallenge.eletrodomesticos.controller.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.techchallenge.eletrodomesticos.controller.exception.dao.ErrorDetails;
import com.techchallenge.eletrodomesticos.dominio.Tensao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException ex) {
        var details = new ErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails> handleValidationException(ValidationException ex) {
        var details = new ErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        var errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof InvalidFormatException) {
            var allowedValues = Arrays.stream(Tensao.values())
                    .map(Tensao::name)
                    .collect(Collectors.joining(", "));
            var errorMessage = "Tensão inválido fornecido. Valores permitidos são: " + allowedValues;

            var details = new ErrorDetails(errorMessage, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
        }

        var details = new ErrorDetails("Erro ao processar a requisição.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
