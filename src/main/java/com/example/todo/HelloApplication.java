package com.example.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 810);
        stage.setTitle("//♣UrusApp♠||◙");
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.TRANSPARENT);
        scene.getWindow().centerOnScreen();
        stage.show();
    }
}