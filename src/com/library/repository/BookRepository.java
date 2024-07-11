package com.library.repository;

import com.library.model.Book;
import com.library.model.User;
import com.library.model.composite.BookCategoryComposite;
import com.library.notifier.BookAvailabilityNotifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private BookCategoryComposite rootCategory;

    private static BookRepository instance;

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    // Método para adicionar livros e usuários para teste
    private BookRepository() {
        books.add(new Book("1", "Effective Java", "Joshua Bloch", "2", 1, false));
        books.add(new Book("2", "Clean Code", "Robert C. Martin", "1", 1,false));
        books.add(new Book("3", "Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1", 1,false));
        books.add(new Book("4", "Java Concurrency in Practice", "Brian Goetz", "2",1,false));

        // Adicionando categorias de exemplo
        rootCategory = new BookCategoryComposite("root", "All Categories");
        BookCategoryComposite programming = new BookCategoryComposite("1", "Programming");
        BookCategoryComposite java = new BookCategoryComposite("2", "Java");
        programming.addSubCategory(java);
        rootCategory.addSubCategory(programming);
    }

    public List<Book> searchBooks(String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Book findBookById(String bookId) {
        return books.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    public BookCategoryComposite getRootCategory() {
        return rootCategory;
    }

    public BookCategoryComposite findCategoryById(String categoryId) {
        return rootCategory.findSubCategoryById(categoryId);
    }

    public void addBook(Book book) {
        int id = books.size();
        book.setId(String.valueOf(id));
        books.add(book);
    }
}
