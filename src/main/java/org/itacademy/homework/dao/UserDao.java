package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.User;

import java.util.List;

public class UserDao implements Dao<User> {

    @Override
    public User get(int id) {
        return DataBase.getUserList().get(id);
    }

    @Override
    public List<User> getAll() {
        return DataBase.getUserList();
    }

    @Override
    public void save(User user) {
        DataBase.getUserList().add(user);
    }

    @Override
    public void delete(User user) {
        DataBase.getUserList().remove(user);
    }

    public void addNewUser(int id, String name, int age) {
        save(new User(id, name, age));
    }

    public void changeName(int id, String name) {
        DataBase.getUserList().get(id).setName(name);
    }

    public void changeAge(int id, int age) {
        DataBase.getUserList().get(id).setAge(age);
    }
}
