package com.library.external;

import com.library.model.Book;
import com.library.model.composite.BookCategoryComposite;

import java.util.ArrayList;
import java.util.List;

public class ExternalCatalogAdapter {
    private List<Book> externalBooks;
    private BookCategoryComposite externalRootCategory;

    public ExternalCatalogAdapter() {
        externalBooks = new ArrayList<>();
        externalRootCategory = new BookCategoryComposite("root", "All Categories");

        // Mock data for external books and categories
        BookCategoryComposite programming = new BookCategoryComposite("1", "Programming");
        BookCategoryComposite java = new BookCategoryComposite("2", "Java");
        programming.addSubCategory(java);
        externalRootCategory.addSubCategory(programming);

        externalBooks.add(new Book("5", "Head First Java", "Kathy Sierra, Bert Bates", "2", 1, false));
        externalBooks.add(new Book("6", "Java: The Complete Reference", "Herbert Schildt", "2", 1, false));
    }

    public List<Book> getBooks() {
        return externalBooks;
    }

    public BookCategoryComposite getRootCategory() {
        return externalRootCategory;
    }

    public void addBook(Book book) {
        int id = externalBooks.size() + 5; // Offset to avoid ID conflict with internal books
        book.setId(String.valueOf(id));
        externalBooks.add(book);
    }

    public void addCategory(BookCategoryComposite category) {
        externalRootCategory.addSubCategory(category);
    }
}
