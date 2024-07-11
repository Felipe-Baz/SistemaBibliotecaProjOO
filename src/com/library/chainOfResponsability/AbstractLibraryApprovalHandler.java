package com.library.chainOfResponsability;

import com.library.model.Book;
import com.library.model.User;

public class AbstractLibraryApprovalHandler implements LibraryApprovalHandler {
    protected LibraryApprovalHandler nextHandler;

    @Override
    public void setNextHandler(LibraryApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handleRequest(Book book, User user) {
        if (nextHandler != null) {
            nextHandler.handleRequest(book, user);
        }
        return true;
    }
}
