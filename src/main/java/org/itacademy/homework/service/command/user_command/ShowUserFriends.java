package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.data.ListOfFriends;
import org.itacademy.homework.model.User;
import org.itacademy.homework.service.command.Command;

public class ShowUserFriends implements Command {
    @Override
    public String execute() {
        return showUserFriends();
    }

    private String showUserFriends() {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : ListOfFriends.getListOfFriends()) {
            stringBuilder.append(user.toString());
            if (index + 1 < ListOfFriends.getListOfFriends().size()) {
                stringBuilder.append("\n");
            }
            index++;
        }
        return stringBuilder.toString();
    }
}
