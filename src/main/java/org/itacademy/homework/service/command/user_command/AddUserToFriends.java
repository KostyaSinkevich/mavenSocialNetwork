package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.data.ListOfFriends;
import org.itacademy.homework.data.UserList;
import org.itacademy.homework.exception.IncorrectUserIdInputException;
import org.itacademy.homework.exception.InvalidTypeEnteredException;
import org.itacademy.homework.model.User;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.CommandHandler;

import java.util.Scanner;

public class AddUserToFriends implements Command {

    Scanner entered;

    @Override
    public String execute() {
        return addToFriends();
    }

    private String addToFriends() {
        int id;

        entered = new Scanner(System.in);
        System.out.println("Enter the id of the user you want to add to friends:");
        System.out.println(new CommandHandler().executeCommand("show all users"));
        try {
            if (entered.hasNextInt()) {
                id = entered.nextInt();
            } else {
                throw new InvalidTypeEnteredException();
            }
            for (User user : UserList.getUserList()) {
                if (user.getId() == id) {
                    ListOfFriends.getListOfFriends().add(user);
                    return "The user has been successfully added to friends";
                }
            }
            throw new IncorrectUserIdInputException();
        } catch (InvalidTypeEnteredException e) {
            System.out.println(e.getMessage());
            return addToFriends();
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
            return addToFriends();
        }
    }
}
