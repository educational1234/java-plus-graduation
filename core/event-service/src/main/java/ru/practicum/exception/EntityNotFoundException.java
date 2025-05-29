package ru.practicum.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> entityClass, String message) {
        super(entityClass.getSimpleName() + message);
    }
}