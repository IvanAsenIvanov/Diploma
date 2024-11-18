package org.application.start.support;

import org.application.start.model.User;
import org.application.start.operation.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database{

    private  String DB_URL = "jdbc:h2:~/test";
    private  String DB_USER = "sa";
    private  String DB_PASSWORD = "";



    public void initDB() throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement stmt = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS users (username VARCHAR(255) PRIMARY KEY, password VARCHAR(255))")) {
                stmt.execute();
            }
        }
    }

    public HashMap<String,User> loadUsers() throws Exception {
        HashMap<String,User> users = UserManager.users;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String username = rs.getString("username");
                        String password = rs.getString("password");
                        User user = new User(id,username,password);
                        users.put(user.getId(), user);
                    }
                }
            }
        }
        return users;
    }

    public void saveUsers(HashMap<String,User> users) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM users")) {
                stmt.execute();
            }

            for (int i=0;i < users.size();i++) {
                User user = users.forEach();
                try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (id, username, password) VALUES (?, ?, ?)")) {
                    stmt.setString(1, user.getId());
                    stmt.setString(2, user.getName());
                    stmt.setString(3, user.getHashedPassword());
                    stmt.execute();
                }
            }
        }
    }
}