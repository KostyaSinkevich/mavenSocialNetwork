package org.itacademy.homework.exception;

public class InvalidTypeEnteredException extends Exception {

    public static final String MESSAGE = "The wrong type has been entered";

    public InvalidTypeEnteredException() {
        super(MESSAGE);
    }
}
