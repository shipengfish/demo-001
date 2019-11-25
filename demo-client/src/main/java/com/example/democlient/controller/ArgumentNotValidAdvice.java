package com.example.democlient.controller;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ArgumentNotValidAdvice {

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void methodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<String> invalidArguments = new ArrayList<>();

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            invalidArguments.add(buildErrorMsg(error));
        }
        throw new RuntimeException(invalidArguments.toString());
    }

    private String buildErrorMsg(FieldError fieldError) {
        String field = fieldError.getField();
        Object rejectedValue = fieldError.getRejectedValue();
        String defaultMessage = fieldError.getDefaultMessage();

        return MessageFormat.format("字段【{0}】值【{1}】，错误原因:【{2}】", field, rejectedValue, defaultMessage);
    }

}
