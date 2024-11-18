package org.application.start.command;


import org.application.start.UI.Input;
import org.application.start.operation.UserManager;

import java.io.IOException;

public class DeleteUserCommand implements Command {
    private UserManager manager;
    private Input id;

    public DeleteUserCommand(UserManager manager, Input id) {
        this.manager = manager;
        this.id = id;
    }

    public void execute() throws IOException {
        manager.deleteUser(id);
    }
}
