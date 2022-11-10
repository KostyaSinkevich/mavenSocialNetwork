package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.dao.ProfileDao;
import org.itacademy.homework.dao.UserDao;
import org.itacademy.homework.dao.WallDao;
import org.itacademy.homework.service.command.Command;

public class AddNewUser implements Command {

    private final ProfileDao profileDao = new ProfileDao();
    private final UserDao userDao = new UserDao();
    private final WallDao wallDao = new WallDao();

    private final String name;
    private final String email;
    private final int age;
    private final String phoneNumber;


    public AddNewUser(String name, String email, int age, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void execute() {
        addNewUser(name, email, age, phoneNumber);
    }

    private void addNewUser(String name, String email, int age, String phoneNumber) {
        int id;
        if (userDao.getAll().isEmpty()) {
            id = 0;
        } else {
            id = userDao.getAll().size();
        }
        userDao.addNewUser(id, name, age);
        profileDao.createNewProfile(id, name, email, age, phoneNumber);
        wallDao.createNewWall(profileDao.get(id));
    }
}
