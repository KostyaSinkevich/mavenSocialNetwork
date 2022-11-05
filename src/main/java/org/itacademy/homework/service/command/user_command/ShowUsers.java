package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.data.UserList;
import org.itacademy.homework.model.User;
import org.itacademy.homework.service.command.Command;

public class ShowUsers implements Command {

    @Override
    public String execute() {
        return showAllUsers();
    }

    private String showAllUsers() {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : UserList.getUserList()) {
            stringBuilder.append(user.toString());
            if (index + 1 < UserList.getUserList().size()) {
                stringBuilder.append("\n");
            }
            index++;
        }
        return stringBuilder.toString();
    }
}
