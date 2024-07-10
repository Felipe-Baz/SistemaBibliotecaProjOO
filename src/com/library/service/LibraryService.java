package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

import java.util.List;

public class LibraryService {
    private BookRepository repository = new BookRepository();

    public List<Book> searchBooks(String keyword) {
        return repository.searchBooks(keyword);
    }

    // Outros métodos do serviço...
}
