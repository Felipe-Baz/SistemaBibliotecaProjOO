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

    public void addObserver(User user) {
        observers.add(user);
    }

    public void removeObserver(User user) {
        observers.remove(user);
    }

    public void notifyNewBookAdded(Book book) {
        String message = "Novo livro adicionado ao catálogo: " + book.getTitle();
        notifyObservers(message);
    }

    public void notifyBookStatusChange(Book book, String status) {
        String message = "O status do livro '" + book.getTitle() + "' mudou para: " + status;
        notifyObservers(message);
    }

    private void notifyObservers(String message) {
        for (User observer : observers) {
            observer.receiveNotification(message);
        }
    }
}
