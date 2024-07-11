package com.library.chainOfResponsability;

import com.library.model.Book;
import com.library.model.User;

public class UserEligibilityHandler extends AbstractLibraryApprovalHandler {
    public boolean handleRequest(Book book, User user) {
        if (user.canBorrowBook()) {
            System.out.println("O usuário é elegível para o empréstimo.");
            return super.handleRequest(book, user);
        } else {
            System.out.println("O usuário não é elegível para o empréstimo.");
            return false;
        }
    }
}
