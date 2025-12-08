package com.example.todo;

import com.example.todo.models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.*;
import java.io.Closeable;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable, Closeable {

    private static final TodoManager manager = new TodoManager();
    @FXML
    private Button exitButton;
    @FXML
    private Button addItemButton;
    @FXML
    private VBox container = new VBox(10);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refreshTodoList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void userInputTodo(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("dialogPane.fxml"));
            DialogPane dialogPane = fxmlLoader.load();
            DialogController dialogController = fxmlLoader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle("//♣UrusNoire♠||◙");
            Optional<ButtonType> result = dialog.showAndWait();
            ButtonType buttonTypeValue = result.get();

            if (buttonTypeValue == ButtonType.OK) {
               dialogController.addProcess();
               refreshTodoList();
            }
        } catch (IOException e) {
            System.out.println("Bad instruction !");
            throw new RuntimeException(e);
        }
    }

    @FXML
    public HBox createTodoField(TodoItem todoItem) {
        TextArea textArea = initTextArea();
        Button removeButton = initRemoveButton();
        HBox hBox = initHBox(removeButton, textArea);
        ContextMenu menu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit");

        edit.setOnAction(event -> {
            updateTodoItem(todoItem);
        });

        menu.getItems().add(edit);
        textArea.setOnMouseClicked(event -> {
            if (event.isPopupTrigger()){
                menu.show(hBox, event.getScreenX(), event.getScreenY());
            }
        });

        textArea.setText(todoItem.toString());
        hBox.setPadding(new Insets(5));
        String todoItemId = todoItem.getId().toString();

        hBox.setId(todoItemId);
        hBox.setMinWidth(500.0);
        hBox.setMinHeight(68.0);
        hBox.setVisible(true);

        removeButton.setOnAction(event -> {
            manager.removeTodoItem(todoItemId);
            try {
                refreshTodoList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } );
//        System.out.println(todoItem);
        return hBox;
    }

    @FXML
    public TextArea initTextArea(){
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefHeight(116.0);
        textArea.setMinWidth(680);
        textArea.setPrefWidth(690);
        textArea.setMaxWidth(700);
        textArea.setEditable(false);
        textArea.setCursor(Cursor.OPEN_HAND);

        return textArea;
    }

    @FXML
    public Button initRemoveButton(){
        Button removeButton = new Button();
        removeButton.setPrefHeight(100.0);
        removeButton.setPrefWidth(50.0);
        Image removeIcon = new Image(getClass().getResourceAsStream("/trash-25.png"));
        ImageView iconView = new ImageView(removeIcon);
        iconView.setFitHeight(30);
        iconView.setFitWidth(30);

        removeButton.setGraphic(iconView);
        removeButton.setAlignment(Pos.CENTER);
        removeButton.setBackground(new Background(new BackgroundFill(Color.web("rgb(176, 1, 3)"), null, null)));
        removeButton.setCursor(Cursor.cursor("Hand"));
        return removeButton;
    }

    @FXML
    public  HBox initHBox(Button button, TextArea textArea){
        HBox hBox = new HBox();
        AnchorPane anchorPane = new AnchorPane();
        SplitPane splitPane = new SplitPane();
        splitPane.setMaxWidth(790.0);

        anchorPane.getChildren().add(splitPane);

        hBox.getChildren().add(anchorPane);
        hBox.setMinWidth(745);
        hBox.setPrefHeight(100);
        hBox.setStyle(" -fx-background-radius : 8.0; -fx-border-radius : 8.0;");

        textArea.setStyle("-fx-background-color : SkyBlue");
        textArea.setFont(Font.font("Cambria"));
        splitPane.setDividerPositions(0.99);
        splitPane.getItems().addAll(textArea, button);
        hBox.getChildren().add(splitPane);

        textArea.setWrapText(true);

        HBox.setHgrow(splitPane, Priority.ALWAYS);
        return hBox;
    }

    @FXML
    public void updateTodoItem(TodoItem todoItem){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("dialogPane.fxml"));
            DialogPane dialogPane = fxmlLoader.load();
            DialogController dialogController = fxmlLoader.getController();

            dialogController.getNoteField().setText(todoItem.getNote());
            dialogController.getTitleField().setText(todoItem.getTitle());

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle("//♣UrusNoire♠||◙");
            Optional<ButtonType> result = dialog.showAndWait();
            ButtonType buttonTypeValue = result.get();

            String note = dialogController.getNoteField().getText();
            String title = dialogController.getTitleField().getText();

            if (buttonTypeValue == ButtonType.OK) {
                if ( note.isEmpty() && title.isEmpty() ){
                    JOptionPane.showMessageDialog(null, "You can't save an empty item!");
                }else {
                    todoItem.setNote(note);
                    todoItem.setTitle(title);
                    manager.updateTodoItem(todoItem);
                    refreshTodoList();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDialogPane(){

    }

    @FXML
    public void refreshTodoList() throws IOException {
        container.getChildren().removeAll(container.getChildren());
        manager.setTodoList(manager.getTodoItems());
        manager.sortTodoList();

        for (TodoItem todoItem : manager.getTodoList()){
            HBox hBox = createTodoField(todoItem);
            hBox.setVisible(true);
            container.getChildren().add(hBox);
        }
    }

    @Override
    public void close() throws IOException {
        System.exit(1);
    }
}