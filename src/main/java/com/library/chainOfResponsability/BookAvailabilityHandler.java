package com.library.chainOfResponsability;

import com.library.model.Book;
import com.library.model.User;

public class BookAvailabilityHandler extends AbstractLibraryApprovalHandler {
    @Override
    public boolean handleRequest(Book book, User user) {
        if (book.isAvailable()) {
            System.out.println("O livro está disponível.");
            return super.handleRequest(book, user);
        } else {
            System.out.println("O livro não está disponível.");
            return false;
        }
    }
}
