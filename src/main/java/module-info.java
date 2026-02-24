module com.example.todo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.example.todo to javafx.fxml;
    opens com.example.todo.models to javafx.fxml;
    opens com.example.todo.contracts to javafx.fxml;

    exports com.example.todo;
    exports com.example.todo.models;
    exports com.example.todo.contracts;
}