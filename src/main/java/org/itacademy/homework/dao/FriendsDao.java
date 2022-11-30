package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.User;

import java.util.List;

public class FriendsDao implements Dao<User> {

    @Override
    public User get(int id) {
        return DataBase.getListOfFriends().get(id);
    }

    @Override
    public List<User> getAll() {
        return DataBase.getListOfFriends();
    }

    @Override
    public void save(User user) {
        DataBase.getListOfFriends().add(user);
    }

    @Override
    public void delete(User user) {
        DataBase.getListOfFriends().remove(user);
    }
}
