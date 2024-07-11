package com.library.notifier;

import com.library.model.Book;
import com.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class BookAvailabilityNotifier {
    private static BookAvailabilityNotifier instance;

    public static BookAvailabilityNotifier getInstance() {
        if (instance == null) {
            instance = new BookAvailabilityNotifier();
        }
        return instance;
    }

    private List<User> observers;

    private BookAvailabilityNotifier() {
        this.observers = new ArrayList<>();
    }

    // Método para adicionar observadores (usuários interessados)
    public void addObserver(User user) {
        observers.add(user);
    }

    // Método para remover observadores (usuários que não estão mais interessados)
    public void removeObserver(User user) {
        observers.remove(user);
    }

    // Método para notificar observadores sobre uma nova adição ao catálogo
    public void notifyNewBookAdded(Book book) {
        String message = "Novo livro adicionado ao catálogo: " + book.getTitle();
        notifyObservers(message);
    }

    // Método para notificar observadores sobre mudança no status de um livro
    public void notifyBookStatusChange(Book book, String status) {
        String message = "O status do livro '" + book.getTitle() + "' mudou para: " + status;
        notifyObservers(message);
    }

    // Método privado para enviar notificações para todos os observadores
    private void notifyObservers(String message) {
        for (User observer : observers) {
            observer.receiveNotification(message);
        }
    }
}
