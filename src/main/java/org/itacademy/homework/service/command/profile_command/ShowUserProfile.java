package org.itacademy.homework.service.command.profile_command;

import org.itacademy.homework.dao.ProfileDao;
import org.itacademy.homework.service.command.Command;

public class ShowUserProfile implements Command {

    private final ProfileDao profileDao = new ProfileDao();

    private final int id;

    public ShowUserProfile(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        showUserProfile();
    }

    private void showUserProfile() {
        System.out.println(profileDao.get(id).toString());
    }
}
