package com.library.facade;

import com.library.chainOfResponsability.BookAvailabilityHandler;
import com.library.chainOfResponsability.LibraryApprovalHandler;
import com.library.chainOfResponsability.LoanLimitHandler;
import com.library.chainOfResponsability.UserEligibilityHandler;
import com.library.model.*;
import com.library.model.composite.BookCategoryComposite;
import com.library.service.BookService;
import com.library.service.UserService;

import java.util.List;

public class LibraryFacade {
    private UserService userService;
    private BookService bookService;
    private LibraryApprovalHandler chain = null;

    public LibraryFacade() {
        this.userService = UserService.getInstance();
        this.bookService = BookService.getInstance();

        configureChain();
    }

    public List<Book> searchBooks(String keyword) {
        return bookService.searchBooks(keyword);
    }

    public boolean borrowBook(String bookId, String userId) {
        User user = getUserInfo(userId);
        Book book = getBookInfo(bookId);

        if(canLoanBook(book, user)) {
            return bookService.borrowBook(bookId, userId);
        } else {
            return false;
        }
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

    private boolean canLoanBook(Book book, User user) {
        return chain.handleRequest(book, user);
    }

    private void configureChain() {
        if(chain == null) {
            LibraryApprovalHandler bookAvailabilityHandler = new BookAvailabilityHandler();
            LibraryApprovalHandler userEligibilityHandler = new UserEligibilityHandler();
            LibraryApprovalHandler loanLimitHandler = new LoanLimitHandler();

            bookAvailabilityHandler.setNextHandler(userEligibilityHandler);
            userEligibilityHandler.setNextHandler(loanLimitHandler);

            this.chain = bookAvailabilityHandler;
        }
    }

    public BookCategoryComposite getRootCategory() {
        return bookService.getRootCategory();
    }

    public BookCategoryComposite getCategoryInfo(String categoryId) {
        return bookService.getCategoryInfo(categoryId);
    }
}
