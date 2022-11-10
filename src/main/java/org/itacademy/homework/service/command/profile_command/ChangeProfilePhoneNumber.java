package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.dao.ProfileDao;
import org.itacademy.homework.exception.IncorrectUserIdInputException;
import org.itacademy.homework.service.command.Command;

public class ChangeProfilePhoneNumber implements Command {

    private final ProfileDao profileDao = new ProfileDao();

    private final int id;
    private final String phoneNumber;

    public ChangeProfilePhoneNumber(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void execute() {
        changePhoneNumber();
    }

    private void changePhoneNumber() {
        try {
            if (id == -1) {
                throw new IncorrectUserIdInputException();
            }
            profileDao.changePhoneNumber(id, phoneNumber);
        } catch (IncorrectUserIdInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
