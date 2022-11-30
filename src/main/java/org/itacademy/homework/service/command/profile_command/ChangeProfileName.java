package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.dao.ProfileDao;
import org.itacademy.homework.exception.IncorrectUserIdInputException;
import org.itacademy.homework.service.command.Command;

public class ChangeProfileName implements Command {

    private final ProfileDao profileDao = new ProfileDao();

    private final int id;
    private final String name;

    public ChangeProfileName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute() {
        changeName();
    }

    private void changeName() {
        try {
            if (id == -1) {
                throw new IncorrectUserIdInputException();
            }
            profileDao.changeName(id, name);
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
