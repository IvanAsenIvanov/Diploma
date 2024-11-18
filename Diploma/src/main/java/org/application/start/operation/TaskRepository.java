package org.application.start.operation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vdurmont.semver4j.Semver;
import org.application.start.UI.Input;
import org.application.start.model.Task;
import org.application.start.UI.Message;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class TaskRepository {
    private static final Logger logger = LogManager.getLogger(TaskRepository.class);
    public List<String> taskList = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    private Message message = new Message();

    private Input input;
    private Task object;
    private int index;
    private String path;

    private Date getCurrentDate() {
        return new Date();
    }

    public void displayAvailableTasks() throws JsonProcessingException {
        for (String task : taskList) {
            System.out.println(mapper.readValue(task, Task.class));
        }
    }

    public String validatePath(String path) {
        File file = new File(path);
        if( file.exists() && file.isFile()){
            return path;
        }
        else{
            return "Invalid path.Try again";
        }
    }




    private boolean checkIfIDMatches(String id) throws IOException {
        if (!checkTaskListSize(taskList)) {
            for (String task : taskList) {
                object = mapper.readValue(task, Task.class);
                if (id.equals(object.id.toString())) {
                    index = taskList.indexOf(task);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkTaskListSize(List<String> taskList) {
        if (taskList.isEmpty()) {
            logger.error("No available tasks");
            return true;
        } else {
            return false;
        }
    }


    public void createTask(String path) {
        try {
            taskList.add(mapper.writeValueAsString(new Task(validatePath(path), "Closed", new Semver("1.0.0"))));
            logger.info("New Task object created with path:" + path + " at:" + getCurrentDate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readTask(String userID) throws IOException {
        if (checkIfIDMatches(userID)) {
            System.out.println(object);
            logger.info("Object read: " + object);
        }
    }

    public void updateTask(String userID) throws IOException {
        if (checkIfIDMatches(userID)) {
            object.version = object.version.nextPatch();
            taskList.set(index, mapper.writeValueAsString(object));
            logger.info("Task updated: " + object);
        }
    }

    public void deleteTask(String userID) throws IOException {
        if (checkIfIDMatches(userID)) {
            taskList.remove(index);
            logger.info("Task removed successfully");
        }
    }



}
