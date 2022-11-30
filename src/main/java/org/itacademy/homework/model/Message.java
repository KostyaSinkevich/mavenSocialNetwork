package org.itacademy.homework.model;

public class Message {

    private String text;
    private final int wallId;

    public Message(String text, Wall wall) {
        this.text = text;
        wallId = wall.getId();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWallId() {
        return wallId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                '}';
    }
}
