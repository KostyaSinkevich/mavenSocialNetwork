package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.dao.UserDao;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.ShowUsersFromDao;

public class ShowUsers implements Command {

    private final UserDao userDao = new UserDao();

    @Override
    public void execute() {
        showAllUsers();
    }

    private void showAllUsers() {
       new ShowUsersFromDao().showUserFromDao(userDao);
    }
}
