package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.Message;
import org.itacademy.homework.model.Wall;

import java.util.List;

public class MessageDao implements Dao<Message> {

    @Override
    public Message get(int id) {
        return DataBase.getPosts().get(id);
    }

    @Override
    public List<Message> getAll() {
        return DataBase.getPosts();
    }

    @Override
    public void save(Message message) {
        DataBase.getPosts().add(message);
    }

    @Override
    public void delete(Message message) {
        DataBase.getPosts().remove(message);
    }

    public void addNewMessage(String text, Wall wall) {
        save(new Message(text, wall));
    }
}
