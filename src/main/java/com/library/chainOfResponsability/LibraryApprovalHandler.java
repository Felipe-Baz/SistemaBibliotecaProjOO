package com.library.chainOfResponsability;

import com.library.model.Book;
import com.library.model.User;

public interface LibraryApprovalHandler {
    void setNextHandler(LibraryApprovalHandler nextHandler);
    boolean handleRequest(Book book, User user);
}
