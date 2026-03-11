package org.spring.prog2finalexamwithspring.Exception;

public class RoomAlreadyBookedException extends RuntimeException{
    public RoomAlreadyBookedException(String message) {
        super(message);
    }
}
