package org.itacademy.homework.service.command;

import org.itacademy.homework.service.command.message_command.CreateNewPost;
import org.itacademy.homework.service.command.message_command.ShowUserPosts;
import org.itacademy.homework.service.command.profile_command.*;
import org.itacademy.homework.service.command.user_command.*;

import java.util.Scanner;

public class CommandHandler {

    private final Scanner scanner = new Scanner(System.in);
    private String enteredByUser;
    private int id;

    public void executeCommand(String command) {
        switch (command.toLowerCase()) {
            case "add new user":
                addNewUser();
                break;
            case "show all users":
                newCommand(new ShowUsers());
                break;
            case "add user to friends":
                addUserToFriends();
                break;
            case "show user friends":
                newCommand(new ShowUserFriends());
                break;
            case "show user profile":
                showUserProfile();
                break;
            case "change profile info":
                selectProfileToChange();
                break;
            case "create new post":
                createUserPost();
                break;
            case "show all user posts":
                showUserPosts();
                break;
            default:
                System.out.println("There is no such command. Try again");
        }
    }

    private void showUserPosts() {
        selectUser("Enter the id of the user who will create the post:");
        newCommand(new ShowUserPosts(id));
    }

    private void createUserPost() {
        selectUser("Enter the id of the user whose posts you want to see:");
        System.out.println("Enter your message:");
        enteredByUser = scanner.nextLine();
        newCommand(new CreateNewPost(id, enteredByUser));
        System.out.println("The post has been successfully created");
    }

    private void selectUser(String message) {
        System.out.println(message);
        new CommandHandler().executeCommand("show all users");
        enteredByUser = scanner.nextLine();
        id = new ConvertStringToInt().convertStringToInt(enteredByUser);
    }

    private void showUserProfile() {
        selectUser("Enter the id of the user whose profile you want to see:");
        newCommand(new ShowUserProfile(id));
    }

    private void addUserToFriends() {
        selectUser("Enter the id of the user you want to add to friends:");
        newCommand(new AddUserToFriends(id));
        System.out.println("the user has been successfully added to friends");
    }

    private void addNewUser() {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = new ConvertStringToInt().convertStringToInt(scanner.nextLine());
        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();
        newCommand(new AddNewUser(name, email, age, phoneNumber));
        System.out.println("the user has been successfully added");
    }

    private void selectProfileToChange() {
        selectUser("Enter the id of the user whose profile you want to change:");
        changeProfileInfo();
    }

    private void changeProfileInfo() {
        System.out.println("Which field do you want to change?: \n" +
                "1 - name \n" +
                "2 - email \n" +
                "3 - age \n" +
                "4 - phone number \n" +
                "Enter apply to apply the settings");
        switch (scanner.nextLine()) {
            case "1":
                System.out.println("Enter new name:");
                enteredByUser = scanner.nextLine();
                newCommand(new ChangeProfileName(id, enteredByUser));
                newCommand(new ChangeUserName(id, enteredByUser));
                System.out.println("The name has been changed");
                changeProfileInfo();
                break;
            case "2":
                System.out.println("Enter new email:");
                enteredByUser = scanner.nextLine();
                newCommand(new ChangeProfileEmail(id, enteredByUser));
                System.out.println("The email has been changed");
                changeProfileInfo();
                break;
            case "3":
                System.out.println("Enter new age:");
                enteredByUser = scanner.nextLine();
                newCommand(new ChangeProfileAge(id, enteredByUser));
                newCommand(new ChangeUserAge(id, enteredByUser));
                System.out.println("The age has been changed");
                changeProfileInfo();
                break;
            case "4":
                System.out.println("Enter new phone number:");
                enteredByUser = scanner.nextLine();
                newCommand(new ChangeProfilePhoneNumber(id, enteredByUser));
                System.out.println("The phone number has been changed");
                changeProfileInfo();
                break;
            case "apply":
                System.out.println("Settings have been successfully applied");
                break;
            default:
                System.out.println("This field doesn't exist");
                changeProfileInfo();
        }
    }

    private void newCommand(Command command) {
        command.execute();
    }
}
