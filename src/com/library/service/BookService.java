package com.library.service;

import com.library.model.*;
import com.library.model.composite.BookCategoryComposite;
import com.library.notifier.BookAvailabilityNotifier;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

import java.util.List;

public class BookService {
    private BookRepository repository = BookRepository.getInstance();
    private UserRepository userRepository = UserRepository.getInstance();
    private BookAvailabilityNotifier notifier = BookAvailabilityNotifier.getInstance();

    public List<Book> searchBooks(String keyword) {
        return repository.searchBooks(keyword);
    }

    public boolean borrowBook(String bookId, String userId) {
        Book book = repository.findBookById(bookId);
        User user = userRepository.findUserById(userId);

        if (book != null && user != null && !book.isBorrowed() && user.canBorrowBook()) {
            book.setBorrowed(true);
            notifier.notifyBookStatusChange(book, "Emprestado");
            return true;
        }
        return false;
    }

    public boolean addBook(Book book, String userId) {
        Book bookId = repository.findBookById(book.getId());
        User user = userRepository.findUserById(userId);

        if (bookId == null && user != null && !book.isBorrowed() && user.canAddBook()) {
            repository.addBook(book);
            notifier.notifyNewBookAdded(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId, String userId) {
        Book book = repository.findBookById(bookId);
        User user = userRepository.findUserById(userId);

        if (book != null && user != null && book.isBorrowed()) {
            book.setBorrowed(false);
            notifier.notifyBookStatusChange(book, "Devolvido");
            return true;
        }
        return false;
    }

    public Book getBookInfo(String bookId) {
        return repository.findBookById(bookId);
    }

    public BookCategoryComposite getRootCategory() {
        return repository.getRootCategory();
    }

    public BookCategoryComposite getCategoryInfo(String categoryId) {
        return repository.findCategoryById(categoryId);
    }
}
