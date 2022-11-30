package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.Profile;

import java.util.List;

public class ProfileDao implements Dao<Profile> {

    @Override
    public Profile get(int id) {
        return DataBase.getProfileList().get(id);
    }

    @Override
    public List<Profile> getAll() {
        return DataBase.getProfileList();
    }

    @Override
    public void save(Profile profile) {
        DataBase.getProfileList().add(profile);
    }

    @Override
    public void delete(Profile profile) {
        DataBase.getProfileList().remove(profile);
    }

    public int createNewProfile(int id, String name, String email, int age, String phoneNumber) {
        Profile profile = new Profile(id, name, email, age, phoneNumber);
        save(profile);
        return profile.getId();
    }

    public void changeName(int id, String name) {
        DataBase.getProfileList().get(id).setName(name);
    }

    public void changeEmail(int id, String email) {
        DataBase.getProfileList().get(id).setEmail(email);
    }

    public void changeAge (int id, int age) {
        DataBase.getProfileList().get(id).setAge(age);
    }

    public void changePhoneNumber(int id, String phoneNumber) {
        DataBase.getProfileList().get(id).setPhoneNumber(phoneNumber);
    }
}
