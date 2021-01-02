package com.daniel.TodoList.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class CustomException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionBody exceptionBody = new ExceptionBody(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionBody,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity<Object> handleAllUsernameExceptions(UsernameNotFoundException ex, WebRequest request) {
        ExceptionBody exceptionBody = new ExceptionBody(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionBody,HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Object> handleCredentialExceptions(BadCredentialsException ex, WebRequest request) {
        ExceptionBody exceptionBody = new ExceptionBody(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionBody,HttpStatus.UNAUTHORIZED);

    }


}
