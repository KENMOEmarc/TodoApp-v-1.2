package com.example.todo;

import com.example.todo.models.TodoItem;
import com.example.todo.models.TodoManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class DialogController {
    @FXML
    private DialogPane dialogPane;

    @FXML
    private TextField titleField;

    @FXML
    private TextArea noteField;

    private TodoManager manager;

    public void addProcess(){
        String shortDescription = getNoteField().getText();
        String title = getTitleField().getText();
        if ( shortDescription.isEmpty() && title.isEmpty() ){
            JOptionPane.showMessageDialog(null, "You can't save an empty item!");
            return;
        }
        TodoItem todoItem = new TodoItem(title, shortDescription);
        manager = new TodoManager();
        manager.addTodoItem(todoItem);
    }

    public void updateProcess(){

    }

    public TextField getTitleField() {
        return titleField;
    }

    public void setTitleField(TextField titleField) {
        this.titleField = titleField;
    }

    public TextArea getNoteField() {
        return noteField;
    }

    public void setNoteField(TextArea noteField) {
        this.noteField = noteField;
    }

}