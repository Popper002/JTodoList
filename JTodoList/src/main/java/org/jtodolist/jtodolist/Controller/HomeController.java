package org.jtodolist.jtodolist.Controller;


import JTodoList.Task.TodoGui;
import JTodoList.Todo.Todo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {

    public ObservableList<TodoGui> getTaskList() {
        return taskList;
    }

    public void setTaskList(ObservableList<TodoGui> taskList) {
        this.taskList = taskList;
    }

    public ObservableList<TodoGui> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(ObservableList<TodoGui> todoItems) {
        this.todoItems = todoItems;
    }

    public ObservableList<TodoGui> getCompleted() {
        return completed;
    }

    public void setCompleted(ObservableList<TodoGui> completed) {
        this.completed = completed;
    }
    public static synchronized HomeController getInstance() {
        if (istance == null) {
            istance = new HomeController();
        }
        return istance;
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    private ObservableList<TodoGui> taskList;
    private ObservableList<TodoGui> todoItems;
    private ObservableList<TodoGui> completed;
    public static HomeController istance;
    HomeController homeController;

            public void openListOfTask(Event event) {
                try {
                    taskList = FXCollections.observableArrayList();
                    setTaskList(taskList);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/jtodolist/jtodolist/View/TaskList.fxml"));
                    Scene newScene = new Scene(fxmlLoader.load());
                    Stage newStage = new Stage();
                    // REMOVE this line:
                    // taskList = homeController.taskList;
                    newStage.setTitle("Task List");
                    newStage.setScene(newScene);
                    newStage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            //readTaskList();

    public void openViewListOfTask(Event event) {
        try {
            taskList = FXCollections.observableArrayList();
            setTaskList(taskList);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/jtodolist/jtodolist/View/ViewTaskList.fxml"));
            Scene newScene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            // REMOVE this line:
            // taskList = homeController.taskList;
            newStage.setTitle("Task List");
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void openRemoveListOfTask(Event event) {
        try {
            taskList = FXCollections.observableArrayList();
            setTaskList(taskList);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/jtodolist/jtodolist/View/RemoveTaskList.fxml"));
            Scene newScene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            // REMOVE this line:
            // taskList = homeController.taskList;
            newStage.setTitle("Task List");
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void openInforPannel(Event event) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informazioni");
            alert.setHeaderText("JTodoList");
            alert.setContentText("Benvenuto in JTodoList!\nGestisci le tue attività facilmente.");
            alert.showAndWait();
        }
}
