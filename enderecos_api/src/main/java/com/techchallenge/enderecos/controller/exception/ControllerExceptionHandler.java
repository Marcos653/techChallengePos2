package com.techchallenge.enderecos.controller.exception;

import com.techchallenge.enderecos.services.exception.ControllerNotFoundException;
import com.techchallenge.enderecos.services.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    private DefaultError error = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFoundException(ControllerNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Entidade não encontrada");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(this.error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> errorEnum(HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Valor inválido");
        error.setPath(request.getRequestURI());
        error.setMessage("Erro no cadastro de endereço");
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    private record DadosErroValidacao(String campo, String mensagem) {

        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }



}
