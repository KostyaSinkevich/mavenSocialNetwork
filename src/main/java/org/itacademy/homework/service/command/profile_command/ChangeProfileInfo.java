package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.data.ProfileList;
import org.itacademy.homework.data.UserList;
import org.itacademy.homework.exception.IncorrectUserIdInputException;
import org.itacademy.homework.exception.InvalidTypeEnteredException;
import org.itacademy.homework.model.Profile;
import org.itacademy.homework.model.User;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.CommandHandler;

import java.util.Scanner;

public class ChangeProfileInfo implements Command {

    Scanner entered;

    @Override
    public String execute() {
        return changeProfileInfo();
    }

    private String changeProfileInfo() {
        int id;

        entered = new Scanner(System.in);
        System.out.println("Enter the id of the user whose profile you want to change:");
        System.out.println(new CommandHandler().executeCommand("show all users"));
        try {
            if (entered.hasNextInt()) {
                id = entered.nextInt();
            } else {
                throw new InvalidTypeEnteredException();
            }
            for (Profile profile : ProfileList.getProfileList()) {
                if (profile.getId() == id) {
                    User user = UserList.getUserList().get(id);
                    return refactorProfile(profile, user);
                }
            }
            throw new IncorrectUserIdInputException();
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
            return changeProfileInfo();
        } catch (InvalidTypeEnteredException e) {
            System.out.println(e.getMessage());
            return changeProfileInfo();
        }
    }

    private String refactorProfile(Profile profile, User user) {
        String enteredByUser;

        entered = new Scanner(System.in);


        System.out.println("Which field do you want to change?: \n" +
                "1 - name \n" +
                "2 - email \n" +
                "3 - age \n" +
                "4 - phone number \n" +
                "Enter apply to apply the settings");

        switch (entered.nextLine()) {
            case "1":
                System.out.println("Enter new name:");
                enteredByUser = entered.nextLine();
                profile.setName(enteredByUser);
                user.setName(enteredByUser);
                System.out.println("The name has been changed");
                return refactorProfile(profile, user);
            case "2":
                System.out.println("Enter new email:");
                enteredByUser = entered.nextLine();
                profile.setEmail(enteredByUser);
                System.out.println("The email has been changed");
                return refactorProfile(profile, user);
            case "3":
                System.out.println("Enter new age:");
                try {
                    int age;
                    if (entered.hasNextInt()) {
                        age = entered.nextInt();
                    } else {
                        throw new InvalidTypeEnteredException();
                    }
                    profile.setAge(age);
                    user.setAge(age);
                } catch (InvalidTypeEnteredException e) {
                    System.out.println(e.getMessage());
                    return refactorProfile(profile, user);
                }
                System.out.println("The age has been changed");
                return refactorProfile(profile, user);
            case "4":
                System.out.println("Enter new phone number:");
                enteredByUser = entered.nextLine();
                profile.setPhoneNumber(enteredByUser);
                System.out.println("The phone number has been changed");
                return refactorProfile(profile, user);
            case "apply":
                return "Settings have been successfully applied";
            default:
                System.out.println("This field doesn't exist");
                return refactorProfile(profile, user);
        }
    }
}
