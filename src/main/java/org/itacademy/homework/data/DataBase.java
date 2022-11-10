package org.itacademy.homework.data;

import org.itacademy.homework.model.Message;
import org.itacademy.homework.model.Profile;
import org.itacademy.homework.model.User;
import org.itacademy.homework.model.Wall;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static List<User> listOfFriends;

    private static List<Profile> profileList;

    private static List<User> userList;

    private static List<Message> posts;

    private static List<Wall> wallList;

    public static List<User> getListOfFriends() {
        if (listOfFriends == null) {
            listOfFriends = new ArrayList<>();
        }
        return listOfFriends;
    }

    public static List<Profile> getProfileList() {
        if (profileList == null) {
            profileList = new ArrayList<>();
        }
        return profileList;
    }

    public static List<User> getUserList() {
        if (userList == null) {
            userList = new ArrayList<>();
        }
        return userList;
    }

    public static List<Message> getPosts() {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        return posts;
    }

    public static List<Wall> getWallList() {
        if (wallList == null) {
            wallList = new ArrayList<>();
        }
        return wallList;
    }
}
