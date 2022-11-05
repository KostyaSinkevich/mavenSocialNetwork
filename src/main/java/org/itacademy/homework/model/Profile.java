package org.itacademy.homework.model;

import org.itacademy.homework.data.ProfileList;

public class Profile extends User {

    private String email;
    private String phoneNumber;
    private final Wall wall;

    public Profile(String name, String email, int age, String phoneNumber) {
        super(name, age);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wall = new Wall(this);
        ProfileList.getProfileList().add(this);
    }

    public Wall getWall() {
        return wall;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Profile{" +
                "id=" + getId() + '\'' +
                " name='" + getName() + '\'' +
                " email='" + email + '\'' +
                ", age=" + getAge() +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}