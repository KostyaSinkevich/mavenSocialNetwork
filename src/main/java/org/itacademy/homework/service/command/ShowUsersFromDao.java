package org.itacademy.homework.service.command;

import org.itacademy.homework.dao.Dao;
import org.itacademy.homework.model.User;

public class ShowUsersFromDao {

    public void showUserFromDao(Dao<User> dao) {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : dao.getAll()) {
            stringBuilder.append(user.toString());
            if (index + 1 < dao.getAll().size()) {
                stringBuilder.append("\n");
            }
            index++;
        }
        System.out.println(stringBuilder.toString());
    }
}
