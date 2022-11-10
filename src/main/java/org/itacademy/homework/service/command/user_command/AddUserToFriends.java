package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.dao.FriendsDao;
import org.itacademy.homework.dao.UserDao;
import org.itacademy.homework.service.command.Command;

public class AddUserToFriends implements Command {

    private final UserDao userDao = new UserDao();
    private final FriendsDao friendsDao = new FriendsDao();

    private final int id;

    public AddUserToFriends(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        addToFriends();
    }

    private void addToFriends() {
        friendsDao.save(userDao.get(id));
    }
}
