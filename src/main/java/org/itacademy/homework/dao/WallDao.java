package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.Profile;
import org.itacademy.homework.model.Wall;

import java.util.List;

public class WallDao implements Dao<Wall> {

    List<Wall> list = DataBase.getWallList();

    @Override
    public Wall get(int id) {
        return list.get(id);
    }

    @Override
    public List<Wall> getAll() {
        return list;
    }

    @Override
    public void save(Wall wall) {
        list.add(wall);
    }

    @Override
    public void delete(Wall wall) {
        list.remove(wall);
    }

    public void createNewWall(Profile profile) {
        save(new Wall(profile));
    }
}
