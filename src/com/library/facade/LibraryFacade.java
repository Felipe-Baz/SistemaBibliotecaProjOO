package com.library.facade;

import com.library.model.*;
import com.library.model.composite.BookCategoryComposite;
import com.library.service.BookService;
import com.library.service.UserService;

import java.util.List;

public class LibraryFacade {
    private UserService userService;
    private BookService bookService;

    public LibraryFacade() {
        this.userService = new UserService();
        this.bookService = new BookService();
    }

    public List<Book> searchBooks(String keyword) {
        return bookService.searchBooks(keyword);
    }

    public boolean borrowBook(String bookId, String userId) {
        return bookService.borrowBook(bookId, userId);
    }

    public boolean returnBook(String bookId, String userId) {
        return bookService.returnBook(bookId, userId);
    }

    public Book getBookInfo(String bookId) {
        return bookService.getBookInfo(bookId);
    }

    public User getUserInfo(String userId) {
        return userService.getUserInfo(userId);
    }

    public boolean addBook(Book book,  String userId) {
        return bookService.addBook(book, userId);
    }

    public boolean addUser(StudentUserType user) {
        return userService.addUser(user);
    }

    public boolean addUser(TeacherUserType user) {
        return userService.addUser(user);
    }

    public boolean addUser(StaffUserType user) {
        return userService.addUser(user);
    }


    public BookCategoryComposite getRootCategory() {
        return bookService.getRootCategory();
    }

    public BookCategoryComposite getCategoryInfo(String categoryId) {
        return bookService.getCategoryInfo(categoryId);
    }
}
