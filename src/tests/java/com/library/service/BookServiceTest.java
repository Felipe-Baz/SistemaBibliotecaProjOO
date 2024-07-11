package com.library.service;

import com.library.model.*;
import com.library.model.composite.BookCategoryComposite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService;

    @Before
    public void setUp() {
        bookService = BookService.getInstance();
    }

    @Test
    public void testSearchBooks() {
        String keyword = "Java";
        assertFalse(bookService.searchBooks(keyword).isEmpty());
    }

    @Test
    public void testBorrowBookSuccess() {
        String bookId = "1"; // Assuming "Effective Java" is available
        String userId = "1"; // Assuming user ID exists and is eligible
        assertTrue(bookService.borrowBook(bookId, userId));
    }

    @Test
    public void testBorrowBookFailure() {
        String bookId = "1"; // Assuming "Effective Java" is already borrowed
        String userId = "5"; // Assuming user ID exists but is not eligible
        assertFalse(bookService.borrowBook(bookId, userId));
    }

    @Test
    public void testAddBookNewBook() {
        String userId = "1"; // Assuming admin user ID
        Book newBook = new Book("5", "New Book", "Author", "2", 1, false);
        assertTrue(bookService.addBook(newBook, userId));
    }

    @Test
    public void testAddBookExistingBook() {
        String userId = "1"; // Assuming admin user ID
        Book existingBook = bookService.getBookInfo("1"); // Assuming "Effective Java" exists
        assertFalse(bookService.addBook(existingBook, userId)); // Adding a copy should fail
    }

    @Test
    public void testReturnBookSuccess() {
        String bookId = "1"; // Assuming "Effective Java" is borrowed by user
        String userId = "1"; // Assuming user ID exists and borrowed the book
        assertTrue(bookService.returnBook(bookId, userId));
    }

    @Test
    public void testGetBookInfo() {
        String bookId = "1"; // Assuming "Effective Java" exists
        Book book = bookService.getBookInfo(bookId);
        assertNotNull(book);
        assertEquals("Effective Java", book.getTitle());
    }

    @Test
    public void testGetRootCategory() {
        BookCategoryComposite rootCategory = bookService.getRootCategory();
        assertNotNull(rootCategory);
        assertEquals("root", rootCategory.getId()); // Assuming root category ID is "root"
    }

    @Test
    public void testGetCategoryInfo() {
        String categoryId = "2"; // Assuming category ID exists
        BookCategoryComposite category = bookService.getCategoryInfo(categoryId);
        assertNotNull(category);
        assertEquals("Java", category.getName());
    }
}
