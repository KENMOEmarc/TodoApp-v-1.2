package com.example.todo.contracts;

import com.example.todo.models.TodoItem;

import java.time.LocalDate;

public interface ITodoManager {

   void addTodoItem(TodoItem item);

   void updateTodoItem(TodoItem todoItem);

   void removeTodoItem(String id);


}
