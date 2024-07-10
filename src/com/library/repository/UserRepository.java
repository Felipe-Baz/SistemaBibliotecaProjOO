package com.library.repository;

import com.library.model.StaffUserType;
import com.library.model.StudentUserType;
import com.library.model.TeacherUserType;
import com.library.model.User;
import com.library.notifier.BookAvailabilityNotifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    BookAvailabilityNotifier notifier = BookAvailabilityNotifier.getInstance();

    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        users.add(new StudentUserType("1", "Neymar", "neymar@example.com"));
        users.add(new StudentUserType("2", "Roberto Goes", "RobertoGoes@example.com"));
        users.add(new TeacherUserType("3", "Ralph Johnson", "RalphJohnson@example.com"));
        users.add(new TeacherUserType("4", "Brian Goetz", "BrianGoetz@example.com"));
        users.add(new StaffUserType("5", "Jose Goetz", "JoseGoetz@example.com"));
        users.add(new StaffUserType("6", "Kleber Goes", "KleberGoes@example.com"));
    }

    public List<User> searchUsers(String keyword) {
        return users.stream()
                .filter(user -> user.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public User findUserById(String userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public void addUser(StudentUserType user) {
        users.add(user);
        notifier.addObserver(user);
    }

    public void addUser(StaffUserType user) {
        users.add(user);
    }

    public void addUser(TeacherUserType user) {
        users.add(user);
    }
}
