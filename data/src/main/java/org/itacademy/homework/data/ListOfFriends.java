package org.itacademy.homework.data;

import org.itacademy.homework.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListOfFriends {

    private static ListOfFriends list;

    private ListOfFriends() {
    }

    private final List<User> listOfFriends = new ArrayList<>();

    public static List<User> getListOfFriends() {
        if (list == null) {
            list = new ListOfFriends();
        }
        return list.listOfFriends;
    }
}
