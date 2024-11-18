package org.application.start.operation;

import org.application.start.UI.Input;
import org.application.start.model.User;

import java.io.IOException;
import java.util.HashMap;

public class UserManager {
    public static HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void createUser(Input input) throws IOException {
        User user = new User(input.getUserInput(),input.getUserInput(),input.getUserInput());
        users.put(user.getId(), user);
    }

    public void updateUser(Input input) throws IOException {
        listUsers();
        User user = new User(input.getUserInput(),input.getUserInput(),input.getUserInput());
        users.replace(user.getId(), user);
    }

    public void deleteUser(Input input) throws IOException {
        String id = input.getUserInput();
        User user = users.remove(id);
        if (user != null) {
            System.out.println("User deleted: " + user.getName());
        }
    }

    public void listUsers() {
        System.out.println("User List:");
        for (User user : users.values()) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
        }
    }
}