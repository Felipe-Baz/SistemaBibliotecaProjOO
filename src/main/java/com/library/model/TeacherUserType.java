package com.library.model;

public class TeacherUserType extends User {
    public TeacherUserType(String id, String name, String email) {
        super(id, name, email);
    }

    public TeacherUserType(String name, String email) {
        super( name, email);
    }

    @Override
    public boolean canBorrowBook() {
        return false;
    }

    public void receiveNotification(String message) {
    }

    public boolean canAddBook() {
        return false;
    }
}
