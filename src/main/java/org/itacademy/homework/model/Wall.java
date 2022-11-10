package org.itacademy.homework.model;

public class Wall {

    private final Profile profile;
    private final int id;

    public Wall(Profile profile) {
        this.profile = profile;
        id = profile.getId();
    }

    public Profile getProfile() {
        return profile;
    }

    public int getId() {
        return id;
    }
}
