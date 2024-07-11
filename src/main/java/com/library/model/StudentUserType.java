package com.library.model;

public class StudentUserType extends User {
    public StudentUserType(String id, String name, String email) {
        super(id, name, email);
    }

    public StudentUserType(String name, String email) {
        super(name, email);
    }

    @Override
    public boolean canBorrowBook() {
        return true;
    }

    public void receiveNotification(String message) {
        System.out.println("Notificação para " + this.getName() + " (" + this.getEmail() + "): " + message);
        // Aqui poderia ser implementada a lógica para enviar a notificação por email, por exemplo
    }

    public boolean canAddBook() {
        return false;
    }
}
