package ru.practicum.category.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    public record ErrorResponse(String message) {
    }

    @ExceptionHandler({CategoryNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(final Exception e) {
        log.error("{} - {}", HttpStatus.NOT_FOUND, e.getMessage(), e);
        return new ErrorResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            IllegalArgumentException.class,
            MethodArgumentNotValidException.class
    })
    public ErrorResponse handleIBadRequestException(final Exception e) {
        log.error("{} - {}", HttpStatus.BAD_REQUEST, e.getMessage(), e);
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse onDataIntegrityViolationException(final Exception e) {
        log.error("{} - {}", HttpStatus.CONFLICT, e.getMessage(), e);
        return new ErrorResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Throwable.class})
    public ErrorResponse handleAnyException(final Exception e) {
        log.error("{} - {}", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        return new ErrorResponse(e.getMessage());
    }
}