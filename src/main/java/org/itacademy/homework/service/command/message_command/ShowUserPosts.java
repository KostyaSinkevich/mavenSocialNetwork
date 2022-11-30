package org.itacademy.homework.service.command.message_command;

import org.itacademy.homework.dao.MessageDao;
import org.itacademy.homework.model.Message;
import org.itacademy.homework.service.command.Command;

public class ShowUserPosts implements Command {

    private final MessageDao messageDao = new MessageDao();

    private final int id;

    public ShowUserPosts(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        showUserPosts();
    }

    private void showUserPosts() {
        for (Message message : messageDao.getAll()) {
            if (message.getWallId() == id) {
                System.out.println(message.toString());
            }
        }
    }
}
