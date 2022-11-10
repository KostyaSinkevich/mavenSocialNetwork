package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.dao.ProfileDao;
import org.itacademy.homework.exception.IncorrectUserIdInputException;
import org.itacademy.homework.service.command.Command;

public class ChangeProfileEmail implements Command {

    private final ProfileDao profileDao = new ProfileDao();

    private final int id;
    private final String email;

    public ChangeProfileEmail(int id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public void execute() {
        changeEmail();
    }

    private void changeEmail() {
        try {
            if (id == -1) {
                throw new IncorrectUserIdInputException();
            }
            profileDao.changeEmail(id, email);
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
