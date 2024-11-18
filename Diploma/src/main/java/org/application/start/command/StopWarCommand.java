package org.application.start.command;

import org.application.start.operation.WARAppController;

public class StopWarCommand implements Command {
    private WARAppController warAppController;

    public StopWarCommand(WARAppController warAppController) {

        this.warAppController = warAppController;
    }

    @Override
    public void execute() {
        warAppController.StopWAR();
    }
}