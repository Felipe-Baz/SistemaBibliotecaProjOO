package com.library.facade;

import com.library.model.*;
import com.library.model.composite.BookCategoryComposite;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryFacadeTest {
    private LibraryFacade libraryFacade;

    @Before
    public void setUp() {
        libraryFacade = new LibraryFacade();
    }

    @Test
    public void testSearchBooks() {
        List<Book> books = libraryFacade.searchBooks("Java");
        assertFalse(books.isEmpty());
        assertTrue(books.stream().anyMatch(book -> book.getTitle().equals("Effective Java")));
    }

    @Test
    public void testBorrowBook() {
        String bookId = "1";
        String userId = "1";
        assertTrue(libraryFacade.borrowBook(bookId, userId));
    }

    @Test
    public void testReturnBook() {
        String bookId = "1";
        String userId = "1";
        assertTrue(libraryFacade.borrowBook(bookId, userId));
        assertTrue(libraryFacade.returnBook(bookId, userId));
    }

    @Test
    public void testGetBookInfo() {
        String bookId = "1";
        Book book = libraryFacade.getBookInfo(bookId);
        assertNotNull(book);
        assertEquals("Effective Java", book.getTitle());
    }

    @Test
    public void testGetUserInfo() {
        String userId = "1";
        User user = libraryFacade.getUserInfo(userId);
        assertNotNull(user);
        assertTrue(user instanceof StudentUserType);
    }

    @Test
    public void testAddBook() {
        String userId = "5";
        Book newBook = new Book("New Book", "Author", "2", false);
        assertTrue(libraryFacade.addBook(newBook, userId));
    }

    @Test
    public void testAddStudentUser() {
        StudentUserType student = new StudentUserType("John Doe", "john.doe@example.com");
        assertTrue(libraryFacade.addUser(student));
    }

    @Test
    public void testAddTeacherUser() {
        TeacherUserType student = new TeacherUserType("John Doe", "john.doe@example.com");
        assertTrue(libraryFacade.addUser(student));
    }

    @Test
    public void testAddStaffUser() {
        StaffUserType student = new StaffUserType("John Doe", "john.doe@example.com");
        assertTrue(libraryFacade.addUser(student));
    }

    @Test
    public void testGetCategoryInfo() {
        String categoryId = "2";
        BookCategoryComposite category = libraryFacade.getCategoryInfo(categoryId);
        assertNotNull(category);
        assertEquals("Java", category.getName());
    }
}
