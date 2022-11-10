package org.itacademy.homework.service.command.user_command;

import org.itacademy.homework.dao.FriendsDao;
import org.itacademy.homework.service.command.Command;
import org.itacademy.homework.service.command.ShowUsersFromDao;

public class ShowUserFriends implements Command {

    private final FriendsDao friendsDao = new FriendsDao();

    @Override
    public void execute() {
        showUserFriends();
    }

    private void showUserFriends() {
        new ShowUsersFromDao().showUserFromDao(friendsDao);
    }
}
