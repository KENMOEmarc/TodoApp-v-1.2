package com.example.todo.models;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.swing.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataBaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/todo";
    private static final String USER = "user";
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    private static void connection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, "password");
            new Alert(Alert.AlertType.INFORMATION, "Connexion Established !").show();
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR, "Connection Failed!", ButtonType.OK).show();
        }
    }

    public void insertTodo(TodoItem todoItem) {
        String sql = "INSERT INTO todoitem VALUES (?, ?, ?, ?)";
        try {
           connection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, todoItem.getId());
                preparedStatement.setString(2, todoItem.getTitle());
                preparedStatement.setString(3, todoItem.getNote());
                preparedStatement.setDate(4, Date.valueOf(todoItem.getCreatedAt()));
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }


    public void updateTodo(TodoItem todoItem) {
        String sql = "UPDATE todoitem SET title = ?, note = ? WHERE id = ?";
        try {
            connection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, todoItem.getTitle());
                preparedStatement.setString(2, todoItem.getNote());
                preparedStatement.setString(3, todoItem.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }


    public void deleteTodo(String todoItemId) {
        String sql = "DELETE FROM todoitem WHERE id = ?";
        try {
            connection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, todoItemId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }

    public ArrayList<TodoItem> fetchAll(){
        ArrayList<TodoItem> todoItems = new ArrayList<>();
        String sql = "SELECT * FROM todoitem ";

        try {
            connection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){
                    todoItems.add(new TodoItem(resultSet.getString("id"), resultSet.getString("title"),
                            resultSet.getString("note"), resultSet.getDate("createAt").toLocalDate()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        closeConnection();
        return todoItems;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close(); // Assuming DataBaseConnection has a close method
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error closing the database connection: " + e.getMessage());
            }
        }
    }
}
