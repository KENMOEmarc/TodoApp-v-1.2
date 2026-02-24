package com.example.todo;

import com.example.todo.models.TodoItem;
import com.example.todo.models.TodoManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class DialogController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea noteField;

    public void addProcess() {
        String shortDescription = getNoteField().getText();
        String title = getTitleField().getText();
        if (shortDescription.isEmpty() && title.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You can't save an empty item!");
            return;
        }
        TodoItem todoItem = new TodoItem(title, shortDescription);
        TodoManager manager = new TodoManager();
        manager.addTodoItem(todoItem);
    }

    public TextField getTitleField() {
        return titleField;
    }

    public TextArea getNoteField() {
        return noteField;
    }
}