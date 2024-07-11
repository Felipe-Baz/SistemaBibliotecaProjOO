package com.library.service;

import com.library.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class UserServiceTest {
    private UserService userService;

    @Before
    public void setUp() {
        userService = UserService.getInstance();
    }

    @Test
    public void testSearchUsers() {
        String keyword = "John";
        List<User> users = userService.searchBooks(keyword);
        assertFalse(users.isEmpty());
    }

    @Test
    public void testGetUserInfo() {
        String userId = "1";
        User user = userService.getUserInfo(userId);
        assertNotNull(user);
        assertEquals("Neymar", user.getName());
    }

    @Test
    public void testAddUserSuccess() {
        StudentUserType newUser = new StudentUserType("7", "Alice Smith", "alice@example.com");
        assertTrue(userService.addUser(newUser));
    }

    @Test
    public void testAddUserFailure() {
        StudentUserType existingUser = new StudentUserType("1", "John Doe", "john@example.com");
        assertFalse(userService.addUser(existingUser));
    }
}
