package org.spring.prog2finalexamwithspring.Exception;

public class RoomNumberNotValidException extends RuntimeException{
    public RoomNumberNotValidException(String message) {
        super(message);
    }
}
