package org.itacademy.homework.exception;

public class IncorrectUserIdInputException extends Exception {

    public static final String MESSAGE = "There is no user with this id";

    public IncorrectUserIdInputException() {
        super(MESSAGE);
    }
}
