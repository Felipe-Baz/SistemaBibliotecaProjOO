package com.library.model;

public class StaffUserType extends User {
    public StaffUserType(String id, String name, String email) {
        super(id, name, email);
    }

    public StaffUserType(String name, String email) {
        super(name, email);
    }

    @Override
    public boolean canBorrowBook() {
        return false;
    }

    public void receiveNotification(String message) {
    }

    public boolean canAddBook() {
        return true;
    }
}
