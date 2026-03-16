![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-17.0.6-blue?logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0.33-4479A1?logo=mysql&logoColor=white)
![Ikonli](https://img.shields.io/badge/Ikonli-11.5.0-2C2C2C?logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-5.10.0-25A162?logo=junit5&logoColor=white)

---

# 📋 Todo Application (JavaFX)

A simple and elegant desktop todo list application built with **JavaFX** and **MySQL**. Manage your tasks with a clean interface, persistent storage, and intuitive controls.

## 🛠️ Technologies

- **Java 17** – Core language  
- **JavaFX 17.0.6** – GUI framework  
- **Maven** – Build and dependency management  
- **MySQL Connector/J 8.0.33** – Database connectivity  
- **Ikonli 11.5.0** – Icon library for JavaFX  
- **JUnit 5.10.0** – Unit testing  

## ✅ Prerequisites

- JDK 17 or later  
- Apache Maven 3.6+  
- MySQL Server (running locally or accessible)  

## 🗄️ Database Setup

The application expects a MySQL database with a specific schema. Follow these steps:

1. Create a database (e.g., `todo`):
   ```sql
   CREATE DATABASE todo;
   ```

2. Create the `todo_items` table (the exact schema is defined in the `TodoManager` model):
   ```sql
   CREATE TABLE todo_items (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       note TEXT
   );
   ```

3. Update the database connection details (URL, username, password) in the `TodoManager` class (look for `DriverManager.getConnection(...)`).  
   ⚠️ Currently these credentials are hard‑coded – you may want to externalise them into a properties file.

## 🚀 Build and Run

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd Todo
   ```

2. Build with Maven:
   ```bash
   mvn clean compile
   ```

3. Launch the application using the JavaFX Maven plugin:
   ```bash
   mvn javafx:run
   ```

The main class is configured as `com.example.todo/com.example.todo.HelloApplication` (module‑class syntax).

## ✨ Features

- **➕ Add a task** – Provide a title and a detailed description.  
- **✏️ Edit a task** – Right‑click on a task to open the edit dialog.  
- **🗑️ Delete a task** – Click the red trash button next to each task.  
- **💾 Persistent storage** – All tasks are saved in a MySQL database.  
- **📐 Responsive layout** – Tasks are displayed in a scrollable list with wrapped text.  
- **🎨 Modern icons** – Ikonli provides clean icons for a polished look.  

## 📁 Project Structure

```
Todo/
├── pom.xml                         – Maven configuration
├── module-info.java                 – Java module descriptor
└── src/
    └── main/
        ├── files/                        - JSON files and sql file
        ├── java/
        │   └── com/example/todo/
        │       ├── HelloApplication.java – Application entry point
        │       ├── HelloController.java  – Main controller
        │       ├── DialogController.java – Dialog controller for add/edit
        │       ├── models/               – Data models
        │          ├── TodoItem.java
        │          └── TodoManager.java
        │       
        └── resources/
            └── com/example/todo/
                ├── dialogPane.fxml       – FXML for the add/edit dialog 
                └── trash-25.png          – Delete button icon             
```

## 📝 Notes

- The project uses **Java modules** – ensure your IDE / runtime respects the module path.  
- The `javafx-maven-plugin` is configured to run the application directly; you can also create a custom JRE image using the plugin’s `jlink` goal.  
- Ikonli icons are bundled via the `ikonli-javafx` dependency – no extra setup required.  

## 👤 Author

- **Developed by** : *Your Name* (or the main contributor)  
- **Repository** : [GitHub repository URL]  
- **Contact** : [Email or other contact information] – optional  

## 📄 License

[MIT](https://choosealicense.com/licenses/mit/) – feel free to modify and use as needed.
