package mk.ukim.finki.books.service;

import mk.ukim.finki.books.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(String id);
    Book saveBook(String title, String isbn, int publishedYear, String authorId);
    void deleteBook(String id);
}