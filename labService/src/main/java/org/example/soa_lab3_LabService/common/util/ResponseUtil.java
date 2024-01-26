package org.example.soa_lab3_LabService.common.util;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseUtil {
    public static Map<String, Object> getErrorBody(HttpStatusCode status, WebRequest webRequest, String message) {
        Map<String, Object> body = new HashMap<>();
        if (status.value() == 404) {
            body.put("code", "LAB_NOT_FOUND");
            body.put("message", "Лабораторная работа не найдена");
        } else {
            body.put("code", "ILLEGAL_ARGUMENT_PROVIDED");
        }
        return body;
    }

    public static List<String> constraintErrors(BindingResult bindingResult) {
        return bindingResult
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }
}
