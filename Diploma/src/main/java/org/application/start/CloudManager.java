package org.application.start;

import org.application.start.command.*;
import org.application.start.operation.*;
import org.application.start.UI.*;
import org.apache.log4j.BasicConfigurator;
import org.application.start.support.Database;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class CloudManager {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Map<String, Command> commandMap = new HashMap<>();
            TaskRepository taskRepo = new TaskRepository();
            Message message = new Message();
            Input input = new Input();
            UserManager userManager = new UserManager();
            RuntimeRepository runtimeRepository = new RuntimeRepository();
            AppController appController = new AppController();
            WARAppController warAppController = new WARAppController();
            Database database = new Database();

           ApplicationBinaryRepository binaryRepository = new ApplicationBinaryRepository("path/to/your/storage/directory");

            database.initDB();
            database.loadUsers();


            commandMap.put("create_task", new TaskCreateCommand(taskRepo,input));
            commandMap.put("read_task", new TaskReadCommand(taskRepo,input));
            commandMap.put("update_task", new TaskUpdateCommand(taskRepo,input));
            commandMap.put("delete_task", new TaskDeleteCommand(taskRepo,input));
            commandMap.put("create_user", new CreateUserCommand(userManager,input));
            commandMap.put("read_user", new ListUsersCommand(userManager));
            commandMap.put("update_user", new UpdateUserCommand(userManager,input));
            commandMap.put("delete_user", new DeleteUserCommand(userManager,input));
            commandMap.put("start_app", new StartAppCommand(appController));
            commandMap.put("start_TomEE_app", new DeployWarCommandTomEE(warAppController));
            commandMap.put("start_Tomcat_app", new DeployWarCommandTomcat(warAppController));
            commandMap.put("stop_war_app", new StopWarCommand(warAppController));
            commandMap.put("stop_app", new StopAppCommand(appController));


            BasicConfigurator.configure();


            Menu menu = new Menu();
            menu.showMenu();
            taskRepo.displayAvailableTasks();
            message.commandInputMessage();

            String operation = reader.readLine().toLowerCase();
            while (!operation.equals("exit")) {
                try {
                    Command command = commandMap.get(operation);
                    command.execute();
                } catch (NullPointerException e) {
                    System.out.println("Incorrect input.Please try again");
                }
                message.commandInputMessage();
                operation = reader.readLine().toLowerCase();
            }

            database.saveUsers(UserManager.users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
