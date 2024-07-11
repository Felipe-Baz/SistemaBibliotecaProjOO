package com.library.external;

import com.library.model.Book;

import java.util.List;

public interface ExternalCatalogService {
    List<Book> searchBooks(String keyword);
    Book getBookInfo(String bookId);
}
