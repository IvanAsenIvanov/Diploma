package org.application.start.model;

    public class User {
        private String id;
        private String username;
        private String hashedPassword;
        private Role role;

        public User(String id,String username, String hashedPassword) {
            this.id = id;
            this.username = username;
            this.hashedPassword = hashedPassword;
            this.role = role;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return username;
        }

        public String getHashedPassword() {
            return hashedPassword;
        }

        public Role getRole() {
            return role;
        }
    }



