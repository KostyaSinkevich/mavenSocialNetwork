package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.User;

import java.util.List;

public class FriendsDao implements Dao<User> {

    List<User> list = DataBase.getListOfFriends();

    @Override
    public User get(int id) {
        return list.get(id);
    }

    @Override
    public List<User> getAll() {
        return list;
    }

    @Override
    public void save(User user) {
        list.add(user);
    }

    @Override
    public void delete(User user) {
        list.remove(user);
    }
}
