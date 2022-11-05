package org.itacademy.homework.model;

import org.itacademy.homework.data.UserList;

public class User {

    private String name;
    private int age;
    private int id;

    private static int count = 0;

    public User(String name, String email, int age, String phoneNumber) {
        new Profile(name, email, age, phoneNumber);
        this.name = name;
        this.age = age;
        id = count++;
        UserList.getUserList().add(this);
    }

    public User(String name,int age) {
        this.name = name;
        this.age = age;
        id = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
