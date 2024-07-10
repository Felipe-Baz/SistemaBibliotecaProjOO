package com.library.service;

import com.library.model.Book;
import com.library.model.User;
import com.library.model.composite.BookCategoryComposite;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

import java.util.List;

public class BookService {
    private BookRepository repository = new BookRepository();
    private UserRepository userRepository = new UserRepository();

    public List<Book> searchBooks(String keyword) {
        return repository.searchBooks(keyword);
    }

    public boolean borrowBook(String bookId, String userId) {
        Book book = repository.findBookById(bookId);
        User user = userRepository.findUserById(userId);

        if (book != null && user != null && !book.isBorrowed() && user.canBorrowBook()) {
            book.setBorrowed(true);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId, String userId) {
        Book book = repository.findBookById(bookId);
        User user = userRepository.findUserById(userId);

        if (book != null && user != null && book.isBorrowed()) {
            book.setBorrowed(false);
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
