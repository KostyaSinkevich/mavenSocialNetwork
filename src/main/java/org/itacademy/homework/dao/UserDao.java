package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.User;

import java.util.List;

public class UserDao implements Dao<User> {

    List<User> list = DataBase.getUserList();

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

    public void addNewUser(int id, String name, int age) {
        save(new User(id, name, age));
    }

    public void changeName(int id, String name) {
        list.get(id).setName(name);
    }

    public void changeAge(int id, int age) {
        list.get(id).setAge(age);
    }
}
