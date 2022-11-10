package org.itacademy.homework.dao;

import org.itacademy.homework.data.DataBase;
import org.itacademy.homework.model.Message;
import org.itacademy.homework.model.Wall;

import java.util.List;

public class MessageDao implements Dao<Message> {

    List<Message> list = DataBase.getPosts();

    @Override
    public Message get(int id) {
        return list.get(id);
    }

    @Override
    public List<Message> getAll() {
        return list;
    }

    @Override
    public void save(Message message) {
        list.add(message);
    }

    @Override
    public void delete(Message message) {
        list.remove(message);
    }

    public void addNewMessage(String text, Wall wall) {
        save(new Message(text, wall));
    }
}
