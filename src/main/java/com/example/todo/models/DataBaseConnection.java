package com.example.todo.models;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.swing.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataBaseConnection {

    private static String dbURL = "jdbc:mysql://localhost:3306/todo";
    private static String user = "username";
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    private static void connection() {
        try {
            connection = DriverManager.getConnection(dbURL, user, "password");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Connexion Established !");
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Connection Failed!", ButtonType.OK);
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

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
        ArrayList<TodoItem> todoItems = new ArrayList<TodoItem>();
        String sql = "SELECT * FROM todoitem ";

        try {
            connection();
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);/* Envoyer le resultet au repositery*/

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
