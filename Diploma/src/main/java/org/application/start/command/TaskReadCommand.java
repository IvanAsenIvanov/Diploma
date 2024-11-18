package org.application.start.command;

import org.application.start.UI.Input;
import org.application.start.operation.TaskRepository;

import java.io.IOException;

public class TaskReadCommand implements Command{
    public TaskRepository task;

    private Input input;

    public TaskReadCommand(TaskRepository task,Input input) {
        this.task = task;
        this.input = input;
    }

    public void execute() throws IOException {

        task.readTask(input.getUserInput());
    }
}
