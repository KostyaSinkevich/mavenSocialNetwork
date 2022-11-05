package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.exception.InvalidTypeEnteredException;
import org.itacademy.homework.model.User;
import org.itacademy.homework.service.command.Command;

import java.util.Scanner;

public class AddNewUser implements Command {

    Scanner entered;

    @Override
    public String execute() {
        return addNewUser();
    }

    private String addNewUser() {
        String name;
        String email;
        String phoneNumber;
        int age;

        entered = new Scanner(System.in);
        System.out.println("Enter your name:");
        name = entered.nextLine();

        System.out.println("Enter your email:");
        email = entered.nextLine();

        System.out.println("Enter your phone number:");
        phoneNumber = entered.nextLine();

        System.out.println("Enter your age:");
        try {
            if (entered.hasNextInt()) {
                age = entered.nextInt();
            } else {
                throw new InvalidTypeEnteredException();
            }
        } catch (InvalidTypeEnteredException e) {
            System.out.println(e.getMessage());
            return addNewUser();
        }
        new User(name, email, age, phoneNumber);
        return "New user has been successfully added";
    }
}
