package com.example.todo.models;

import com.example.todo.HelloController;
import com.example.todo.contracts.IFileService;
import com.example.todo.contracts.ITodoManager;
import javafx.fxml.FXML;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class
TodoManager implements ITodoManager, IFileService {
    private ArrayList<TodoItem> todoList ;
    private DataBaseConnection dataBase;

    public TodoManager() {
        todoList = new ArrayList<TodoItem>();
        dataBase = new DataBaseConnection();
    }

    public void sortTodoList() {
        todoList.sort((item1, item2) -> item1.getCreatedAt().compareTo(item2.getCreatedAt()));
    }

    @Override
    public void addTodoItem(TodoItem item) {
        appendTodoItem(item);
    }

    @Override
    public boolean appendTodoItem(TodoItem todoItem){
        todoList.add(todoItem);
        dataBase.insertTodo(todoItem);
        return true;
    }

    @Override
    public void updateTodoItem(TodoItem todoItem) {
        dataBase.updateTodo(todoItem);
    }

    @Override
    public ArrayList<TodoItem> getTodoItems() {
        return dataBase.fetchAll();
    }

    @FXML
    public void removeTodoItem(String todoItemId){

        for (TodoItem item : todoList) {
            if (item.getId().equals(todoItemId)) {
                todoList.remove(item);
                break;
            }
        }

        try {
            dataBase.deleteTodo(todoItemId);
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null,"NullPointer");
        } catch (RuntimeException e){
            JOptionPane.showMessageDialog(null,"Item was not remove! Try again.");
        }
    }

    public ArrayList<TodoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(ArrayList<TodoItem> todoList) {
        this.todoList = todoList;
    }

}
