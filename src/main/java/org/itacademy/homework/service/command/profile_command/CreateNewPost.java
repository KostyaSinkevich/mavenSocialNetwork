package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.data.ProfileList;
import org.itacademy.homework.exception.IncorrectUserIdInputException;
import org.itacademy.homework.exception.InvalidTypeEnteredException;
import org.itacademy.homework.model.Message;
import org.itacademy.homework.model.Profile;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.CommandHandler;

import java.util.Scanner;

public class CreateNewPost implements Command {

    Scanner entered;

    @Override
    public String execute() {
        return createNewPost();
    }

    private String createNewPost() {
        int id;

        entered = new Scanner(System.in);
        System.out.println("Enter the id of the user whose post you want to create:");
        System.out.println(new CommandHandler().executeCommand("show all users"));
        try {
            if (entered.hasNextInt()) {
                id = entered.nextInt();
            } else {
                throw new InvalidTypeEnteredException();
            }
            for (Profile profile : ProfileList.getProfileList()) {
                if (profile.getId() == id) {
                    System.out.println("Enter your message:");
                    profile.getWall().getPosts().add(new Message(entered.nextLine()));
                    return "The post has been successfully created";
                }
            }
            throw new IncorrectUserIdInputException();
        } catch (InvalidTypeEnteredException e) {
            System.out.println(e.getMessage());
            return createNewPost();
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
            return createNewPost();
        }
    }
}
