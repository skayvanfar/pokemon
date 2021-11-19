package ir.skpokemon.controller;

import ir.skpokemon.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FileNotFoundException.class)
    public void handleFileNotFoundException(FileNotFoundException e) {
        log.error("CSV file not found " + e.getMessage() + e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NumberFormatException.class)
    public void handleNumberFormatException(NumberFormatException e) {
        log.error("Number Format Exception " + e.getMessage(), e);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error("Resource Not Found Exception " + e.getMessage(), e);
    }
}
