package com.library.chainOfResponsability;

import com.library.config.ConfigurationManager;
import com.library.model.Book;
import com.library.model.User;

public class LoanLimitHandler extends AbstractLibraryApprovalHandler {
    ConfigurationManager configManager = ConfigurationManager.getInstance();

    @Override
    public boolean handleRequest(Book book, User user) {
        if (user.getLoanedBooksCount() < configManager.getLoanLimit()) {
            System.out.println("O usuário não atingiu o limite de empréstimos.");
            return super.handleRequest(book, user);
        } else {
            System.out.println("O usuário atingiu o limite de empréstimos.");
            return false;
        }
    }
}
