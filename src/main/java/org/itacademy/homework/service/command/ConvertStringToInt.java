package org.itacademy.homework.service.command;

public class ConvertStringToInt {

    public int convertStringToInt(String entered) {
        if (isNumber(entered)) {
            return Integer.parseInt(entered);
        }
        return -1;
    }

    public boolean isNumber(String enteredByUser) {
        try {
            Integer.parseInt(enteredByUser);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("The wrong type has been entered");
            return false;
        }
    }
}
