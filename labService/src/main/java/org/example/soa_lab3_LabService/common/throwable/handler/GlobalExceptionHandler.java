package org.example.soa_lab3_LabService.common.throwable.handler;

import org.example.soa_lab3_LabService.common.throwable.exception.BadRequestException;
import org.example.soa_lab3_LabService.common.throwable.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;

import static org.example.soa_lab3_LabService.common.util.ResponseUtil.constraintErrors;
import static org.example.soa_lab3_LabService.common.util.ResponseUtil.getErrorBody;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
        return new ResponseEntity<>(getErrorBody(HttpStatus.BAD_REQUEST, request, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(getErrorBody(HttpStatus.NOT_FOUND, request, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> body = getErrorBody(status, request, "ILLEGAL_ARGUMENT_PROVIDED");
        body.put("messages", String.join("***", constraintErrors(ex.getBindingResult()).toArray(String[]::new)));
        return new ResponseEntity<>(body, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> body = getErrorBody(status, request, "body_error");
        body.put("messages", List.of("Ошбибка тела запроса"));
        return new ResponseEntity<>(body, status);
    }
}
