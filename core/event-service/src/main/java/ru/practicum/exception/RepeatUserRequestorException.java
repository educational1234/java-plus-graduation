package ru.practicum.exception;

public class RepeatUserRequestorException extends RuntimeException {
    public RepeatUserRequestorException(String message) {
        super(message);
    }
}