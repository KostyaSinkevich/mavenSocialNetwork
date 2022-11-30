package org.itacademy.homework.data;

import org.itacademy.homework.model.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileList {

    private static ProfileList list;

    private ProfileList() {
    }

    private final List<Profile> profileList = new ArrayList<>();

    public static List<Profile> getProfileList() {
        if (list == null) {
            list = new ProfileList();
        }
        return list.profileList;
    }

}
