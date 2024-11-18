package org.application.start.command;

import org.application.start.UI.Input;
import org.application.start.model.User;
import org.application.start.operation.UserManager;

import java.io.IOException;

public class CreateUserCommand implements Command {
    private UserManager manager;
    private Input user;

    public CreateUserCommand(UserManager manager, Input user) {
        this.manager = manager;
        this.user = user;
    }

    public void execute() throws IOException {
        manager.createUser(user);
    }
}

