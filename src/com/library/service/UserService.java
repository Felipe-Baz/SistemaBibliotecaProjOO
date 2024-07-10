package com.library.service;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository = new UserRepository();

    public List<User> searchBooks(String keyword) {
        return repository.searchUsers(keyword);
    }

    public boolean returnUser(String bookId, String userId) {
        User user = repository.findUserById(bookId);
        if (user != null) {
            return true;
        }
        return false;
    }

    public User getUserInfo(String userId) {
        return repository.findUserById(userId);
    }
}
