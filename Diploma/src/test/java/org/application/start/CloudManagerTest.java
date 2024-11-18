package org.application.start;

import org.apache.log4j.BasicConfigurator;
import org.application.start.UI.Input;
import org.application.start.UI.Menu;
import org.application.start.UI.Message;
import org.application.start.command.*;
import org.application.start.operation.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;



class CloudManagerTest {


    @Test
    void setup(){
        Map<String, Command> commandMap = new HashMap<>();
        TaskRepository taskRepo = new TaskRepository();
        Message message = new Message();
        Input input = new Input();

        commandMap.put("create", new TaskCreateCommand(taskRepo,input));
        commandMap.put("read", new TaskReadCommand(taskRepo,input));
        commandMap.put("update", new TaskUpdateCommand(taskRepo,input));
        commandMap.put("delete", new TaskDeleteCommand(taskRepo,input));

        BasicConfigurator.configure();

        Menu menu = new Menu();
        menu.showMenu();
        message.commandInputMessage();

    }

}