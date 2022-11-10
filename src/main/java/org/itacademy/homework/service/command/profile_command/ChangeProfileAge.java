package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.dao.ProfileDao;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.ConvertStringToInt;

public class ChangeProfileAge implements Command {

    private final ProfileDao profileDao = new ProfileDao();

    private final int id;
    private final String age;

    public ChangeProfileAge(int id, String age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public void execute() {
        changeAge();
    }

    private void changeAge() {
        int age = new ConvertStringToInt().convertStringToInt(this.age);
        profileDao.changeAge(id, age);
    }
}
