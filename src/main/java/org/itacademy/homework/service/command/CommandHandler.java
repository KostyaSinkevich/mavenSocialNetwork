package org.itacademy.homework.service.command;

import org.itacademy.homework.service.command.profile_command.ChangeProfileInfo;
import org.itacademy.homework.service.command.profile_command.CreateNewPost;
import org.itacademy.homework.service.command.profile_command.ShowUserProfile;
import org.itacademy.homework.service.command.user_command.*;

public class CommandHandler {

    public String executeCommand(String command) {
        switch (command.toLowerCase()) {
            case "add new user":
                return newCommand(new AddNewUser());
            case "show all users":
                return newCommand(new ShowUsers());
            case "add user to friends":
                return newCommand(new AddUserToFriends());
            case "show user friends":
                return newCommand(new ShowUserFriends());
            case "show user profile":
                return newCommand(new ShowUserProfile());
            case "change profile info":
                return newCommand(new ChangeProfileInfo());
            case "create new post":
                return newCommand(new CreateNewPost());
            case "show all user posts":
                return newCommand(new ShowUserPosts());
            default:
                return "There is no such command. Try again";
        }
    }

    private String newCommand(Command command) {
        return command.execute();
    }
}
