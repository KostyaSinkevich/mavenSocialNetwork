package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.Profile;

import java.util.List;

public class ProfileDao implements Dao<Profile> {

    List<Profile> list = DataBase.getProfileList();

    @Override
    public Profile get(int id) {
        return list.get(id);
    }

    @Override
    public List<Profile> getAll() {
        return list;
    }

    @Override
    public void save(Profile profile) {
        list.add(profile);
    }

    @Override
    public void delete(Profile profile) {
        list.remove(profile);
    }

    public int createNewProfile(int id, String name, String email, int age, String phoneNumber) {
        Profile profile = new Profile(id, name, email, age, phoneNumber);
        save(profile);
        return profile.getId();
    }

    public void changeName(int id, String name) {
        list.get(id).setName(name);
    }

    public void changeEmail(int id, String email) {
        list.get(id).setEmail(email);
    }

    public void changeAge (int id, int age) {
        list.get(id).setAge(age);
    }

    public void changePhoneNumber(int id, String phoneNumber) {
        list.get(id).setPhoneNumber(phoneNumber);
    }
}
