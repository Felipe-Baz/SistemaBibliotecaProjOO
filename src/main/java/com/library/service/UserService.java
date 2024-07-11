package com.library.service;

import com.library.model.*;
import com.library.model.StaffUserType;
import com.library.model.StudentUserType;
import com.library.model.TeacherUserType;
import com.library.model.User;
import com.library.repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository = UserRepository.getInstance();

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

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

    public boolean addUser(StudentUserType newUser) {
        if(newUser.getId() != null) {
            User user = repository.findUserById(newUser.getId());
            if (user != null) {
                return false;
            }
        }

        repository.addUser(newUser);
        return true;
    }

    public boolean addUser(TeacherUserType newUser) {
        if(newUser.getId() != null) {
            User user = repository.findUserById(newUser.getId());
            if (user != null) {
                return false;
            }
        }

        repository.addUser(newUser);
        return true;
    }

    public boolean addUser(StaffUserType newUser) {
        if(newUser.getId() != null) {
            User user = repository.findUserById(newUser.getId());
            if (user != null) {
                return false;
            }
        }

        repository.addUser(newUser);
        return true;
    }
}
