package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.Profile;
import org.itacademy.homework.model.Wall;

import java.util.List;

public class WallDao implements Dao<Wall> {

    @Override
    public Wall get(int id) {
        return DataBase.getWallList().get(id);
    }

    @Override
    public List<Wall> getAll() {
        return DataBase.getWallList();
    }

    @Override
    public void save(Wall wall) {
        DataBase.getWallList().add(wall);
    }

    @Override
    public void delete(Wall wall) {
        DataBase.getWallList().remove(wall);
    }

    public void createNewWall(Profile profile) {
        save(new Wall(profile));
    }
}
