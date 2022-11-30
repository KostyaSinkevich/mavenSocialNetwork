package org.itacademy.homework.service.command.message_command;

import org.itacademy.homework.dao.MessageDao;
import org.itacademy.homework.dao.WallDao;
import org.itacademy.homework.model.Message;
import org.itacademy.homework.service.command.Command;

public class CreateNewPost implements Command {

    private final MessageDao messageDao = new MessageDao();
    private final WallDao wallDao = new WallDao();

    private final int id;
    private final String text;

    public CreateNewPost(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public void execute() {
        createNewPost();
    }

    private void createNewPost() {
        messageDao.addNewMessage(text, wallDao.get(id));
    }
}
