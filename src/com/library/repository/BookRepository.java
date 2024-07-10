package com.library.repository;

import com.library.model.Book;
import com.library.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    // Método para adicionar livros e usuários para teste
    public BookRepository() {
        books.add(new Book("1", "Effective Java", "Joshua Bloch", false));
        books.add(new Book("2", "Clean Code", "Robert C. Martin", false));
        books.add(new Book("3", "Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", false));
        books.add(new Book("4", "Java Concurrency in Practice", "Brian Goetz", false));
    }

    public List<Book> searchBooks(String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Métodos para adicionar livros, usuários, buscar livros, etc.
}
