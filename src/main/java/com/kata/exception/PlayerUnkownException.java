package com.kata.exception;

public class PlayerUnkownException extends RuntimeException {
    public PlayerUnkownException(String message) {
        super(message);
    }
}
