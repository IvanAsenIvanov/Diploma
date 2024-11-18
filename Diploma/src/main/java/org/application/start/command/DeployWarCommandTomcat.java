package org.application.start.command;

import org.application.start.operation.WARAppController;

public class DeployWarCommandTomcat implements Command {
    private WARAppController warAppController;

    public DeployWarCommandTomcat(WARAppController warAppController) {

        this.warAppController = warAppController;
    }

    @Override
    public void execute() {
        warAppController.StartTomcatApp();
    }
}