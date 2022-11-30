package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.dao.UserDao;
import org.itacademy.homework.service.command.Command;

public class ChangeUserName implements Command {

    private final UserDao userDao = new UserDao();

    private final int id;
    private final String name;

    public ChangeUserName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        userDao.changeName(id, name);
    }
}
