package org.itacademy.homework.model;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private final Profile profile;
    private final List<Message> posts = new ArrayList<>();

    public Wall(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Message> getPosts() {
        return posts;
    }
}
