package org.itacademy.homework.application;

import org.itacademy.homework.service.command.CommandHandler;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner usersRequest = new Scanner(System.in);
        CommandHandler commandHandler = new CommandHandler();
        String command;

        do {
            command = usersRequest.nextLine();
            commandHandler.executeCommand(command);
        } while (!command.equalsIgnoreCase("exit"));

    }
}
