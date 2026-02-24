package com.example.todo.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class TodoItem implements Serializable {

    private final String id;
    private String title;
    private String note;
    private final LocalDate createdAt;

    public TodoItem(String title, String note){
        this.title = title;
        this.note = note;
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDate.now();
    }

    public TodoItem(String id, String title, String note, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.createdAt = createdAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return title + " \n " + note + " \n " +  createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
