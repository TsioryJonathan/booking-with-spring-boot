package org.spring.prog2finalexamwithspring.Advice;

import org.spring.prog2finalexamwithspring.Exception.RoomAlreadyBookedException;
import org.spring.prog2finalexamwithspring.Exception.RoomNumberNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoomAlreadyBookedException.class)
    public ResponseEntity<String> handleRoomAlreadyBookedException(RoomAlreadyBookedException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(RoomNumberNotValidException.class)
    public ResponseEntity<String> handleRoomNumberNotValidException(RoomNumberNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
