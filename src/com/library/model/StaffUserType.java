package com.library.model;

public class StaffUserType extends User {
    public StaffUserType(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrowBook() {
        return false;
    }

    // Outros métodos específicos para funcionários...
}
