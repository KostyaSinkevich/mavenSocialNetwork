package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.data.ProfileList;
import org.itacademy.homework.exception.IncorrectUserIdInputException;
import org.itacademy.homework.exception.InvalidTypeEnteredException;
import org.itacademy.homework.model.Profile;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.CommandHandler;

import java.util.Scanner;

public class ShowUserProfile implements Command {

    Scanner entered;

    @Override
    public String execute() {
        return showUserProfile();
    }

    private String showUserProfile() {
        int id;

        entered = new Scanner(System.in);
        System.out.println("Enter the id of the user whose profile you want to view:");
        System.out.println(new CommandHandler().executeCommand("show all users"));
        try {
            if (entered.hasNextInt()) {
                id = entered.nextInt();
            } else {
                throw new InvalidTypeEnteredException();
            }
            for (Profile profile : ProfileList.getProfileList()) {
                if (profile.getId() == id) {
                    return profile.toString();
                }
            }
            throw new IncorrectUserIdInputException();
        } catch (InvalidTypeEnteredException e) {
            System.out.println(e.getMessage());
            return showUserProfile();
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
            return showUserProfile();
        }
    }
}
