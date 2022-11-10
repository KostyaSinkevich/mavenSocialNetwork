package org.itacademy.homework.model;

public class Profile extends User {

    private String email;
    private String phoneNumber;

    public Profile(int id, String name, String email, int age, String phoneNumber) {
        super(id, name, age);
        this.email = email;
        this.phoneNumber = phoneNumber;
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