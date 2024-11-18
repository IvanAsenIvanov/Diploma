package org.application.start.command;

import org.application.start.UI.Input;
import org.application.start.operation.UserManager;

import java.io.IOException;

public class UpdateUserCommand implements Command {
    private UserManager manager;
    private Input input;

    public UpdateUserCommand(UserManager manager, Input input) {
        this.manager = manager;
        this.input = input;
    }

    public void execute() throws IOException {
        manager.updateUser(input);
    }
}


