package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.dao.UserDao;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.ConvertStringToInt;

public class ChangeUserAge implements Command {

    private final UserDao userDao = new UserDao();

    private final int id;
    private final String age;

    public ChangeUserAge(int id, String age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public void execute() {
        changeAge();
    }

    private void changeAge() {
        int age = new ConvertStringToInt().convertStringToInt(this.age);
        userDao.changeAge(id, age);
    }
}
