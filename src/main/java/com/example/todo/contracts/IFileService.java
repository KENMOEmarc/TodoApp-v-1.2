package com.example.todo.contracts;

import java.sql.SQLException;
import java.util.ArrayList;
import com.example.todo.models.TodoItem;

import java.util.List;

public interface IFileService {
    boolean appendTodoItem(TodoItem todoItem) throws SQLException;
    ArrayList<TodoItem> getTodoItems();
    void removeTodoItem(String todoItemId);
}
