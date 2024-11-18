package org.application.start.command;

import org.application.start.operation.AppController;

public class StartAppCommand implements Command {


    private AppController appController;


    public StartAppCommand(AppController appController) {
        this.appController = appController;
    }

    public void execute() {
        appController.startApplication();
    }
}



