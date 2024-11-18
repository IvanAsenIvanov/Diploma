package org.application.start.command;

import org.application.start.UI.Input;
import org.application.start.operation.UserManager;

public class ListUsersCommand implements Command {
    private UserManager manager;
    private Input user;

    public ListUsersCommand(UserManager manager) {
        this.manager = manager;
    }

    public void execute() {
        manager.listUsers();
    }
}
