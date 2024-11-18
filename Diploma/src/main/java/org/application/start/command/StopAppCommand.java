package org.application.start.command;

import org.application.start.operation.AppController;

public class StopAppCommand implements Command {


    private AppController appController;


    public StopAppCommand(AppController appController) {
        this.appController = appController;
    }

    public void execute() {
        appController.stopApplication();
    }
}



