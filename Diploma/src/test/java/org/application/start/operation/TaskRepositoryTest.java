package org.application.start.operation;

import org.application.start.UI.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class TaskRepositoryTest {
    TaskRepository taskRepo = new TaskRepository();
    List<String> taskList = new ArrayList<>();

    @BeforeEach
    void setup(){
        taskList.add("Task{path='asdf', id=674fa4a7-1345-4245-99ba-2287c40f0ed8, " +
                "dateCreated=Wed Mar 08 13:05:51 EET 2023, status='Closed', " +
                "version=1.0.0}");
    }

    String UserInput() {
        return "ADSA";
    }

    String UserID(){
      return  "674fa4a7-1345-4245-99ba-2287c40f0ed8";
    }


    @Test
    void checkTaskListSizeEmptyTest() {
        TaskRepository taskRepo = new TaskRepository();
        List<String> taskList = new ArrayList<>();
        assertTrue(taskRepo.checkTaskListSize(taskList));
    }


    @Test
    void TasklistShouldNotBeEmpty() {
        setup();
        TaskRepository taskRepo = new TaskRepository();
        List<String> taskList = new ArrayList<>();
        assertTrue(taskRepo.checkTaskListSize(taskList));
    }

    @Test
    void TaskShouldBeCreated() {
        taskRepo.createTask(UserInput());
        assertFalse(taskRepo.checkTaskListSize(taskList));
    }

    @Test
    void TaskShouldBeRead() throws IOException {
        setup();
        taskRepo.readTask(UserID());
        assertFalse(taskRepo.checkTaskListSize(taskList));
    }

    @Test
    void TaskShouldBeDeleted() throws IOException {
        taskRepo.deleteTask(UserID());
        assertFalse(taskRepo.checkTaskListSize(taskList));
    }

    @Test
    void TaskShouldBeUpdated() throws IOException {
        setup();
        taskRepo.updateTask(UserID());
        assertFalse(taskRepo.checkTaskListSize(taskList));
    }

}