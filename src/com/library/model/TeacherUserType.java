package com.library.model;

public class TeacherUserType extends User {
    public TeacherUserType(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrowBook() {
        // Implementar a lógica específica para professores
        return false;
    }

    // Outros métodos específicos para professores...
}
