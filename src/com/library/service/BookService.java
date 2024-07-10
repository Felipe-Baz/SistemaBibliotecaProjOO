package com.library.service;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository repository = new BookRepository();

    public List<Book> searchBooks(String keyword) {
        return repository.searchBooks(keyword);
    }

    public boolean borrowBook(String bookId, String userId) {
        Book book = repository.findBookById(bookId);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId, String userId) {
        Book book = repository.findBookById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            return true;
        }
        return false;
    }

    public Book getBookInfo(String bookId) {
        return repository.findBookById(bookId);
    }

}
