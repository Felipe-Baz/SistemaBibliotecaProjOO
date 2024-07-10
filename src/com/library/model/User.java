package com.library.model;

public abstract class User {
    private String id;
    private String name;

    // Construtor padrão
    public User() {
    }

    // Construtor com parâmetros
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean canBorrowBook();
}
