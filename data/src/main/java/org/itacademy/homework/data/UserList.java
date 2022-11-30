package org.itacademy.homework.data;

import org.itacademy.homework.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static UserList list;

    private UserList() {
    }

    private final List<User> userList = new ArrayList<>();

    public static List<User> getUserList() {
        if (list == null) {
            list = new UserList();
        }
        return list.userList;
    }
}
