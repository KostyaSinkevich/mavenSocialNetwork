package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.CommandHandler;
import org.itacademy.homework.data.ProfileList;
import org.itacademy.homework.service.exception.IncorrectUserIdInputException;
import org.itacademy.homework.service.exception.InvalidTypeEnteredException;
import org.itacademy.homework.model.Message;
import org.itacademy.homework.model.Profile;

import java.util.Scanner;

public class ShowUserPosts implements Command {

    Scanner entered;

    @Override
    public String execute() {
        return showUserPosts();
    }

    private String showUserPosts() {
        int id;

        entered = new Scanner(System.in);
        System.out.println("Enter the id of the user whose posts you want to view:");
        System.out.println(new CommandHandler().executeCommand("show all users"));
        try {
            if (entered.hasNextInt()) {
                id = entered.nextInt();
            } else {
                throw new InvalidTypeEnteredException();
            }
            for (Profile profile : ProfileList.getProfileList()) {
                if (profile.getId() == id) {
                    for (Message message : profile.getWall().getPosts()) {
                        System.out.println(message.toString());
                    }
                    return "";
                }
            }
            throw new IncorrectUserIdInputException();
        } catch (InvalidTypeEnteredException e) {
            System.out.println(e.getMessage());
            return showUserPosts();
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
            return showUserPosts();
        }
    }
}
