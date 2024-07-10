package com.library.repository;

import com.library.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    // Método para adicionar livros e usuários para teste
    public UserRepository() {
        users.add(new User("1", "Nome 1"));
        users.add(new User("2", "Roberto Goes"));
        users.add(new User("3", "Ralph Johnson"));
        users.add(new User("4", "Brian Goetz"));
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

    // Métodos para adicionar livros, usuários, buscar livros, etc.
}
