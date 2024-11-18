package org.application.start.command;

import org.application.start.operation.WARAppController;

public class DeployWarCommandTomEE implements Command {
    private WARAppController warAppController;

    public DeployWarCommandTomEE(WARAppController warAppController) {

        this.warAppController = warAppController;
    }

    @Override
    public void execute() {
        warAppController.StartTomEEApp();
    }
}