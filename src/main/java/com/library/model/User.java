package com.library.model;

public abstract class User {
    private String id;
    private String name;
    private String email;
    private int loanedBooksCount;

    // Construtor com parâmetros
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract boolean canBorrowBook();

    public abstract boolean canAddBook();

    public abstract void receiveNotification(String message);

    public int getLoanedBooksCount() {
        return loanedBooksCount;
    }

    public void setLoanedBooksIncrement() {
        this.loanedBooksCount++;
    }

    public void setLoanedBooksDecrement() {
        this.loanedBooksCount--;
    }
}
