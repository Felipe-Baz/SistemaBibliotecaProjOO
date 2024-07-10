package com.library.model;

public class StudentUserType extends User {
    public StudentUserType(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrowBook() {
        // Implementar a lógica específica para estudantes
        return true;
    }

    // Outros métodos específicos para estudantes...
}
