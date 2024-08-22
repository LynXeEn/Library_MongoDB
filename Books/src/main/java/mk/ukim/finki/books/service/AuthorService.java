package mk.ukim.finki.books.service;

import mk.ukim.finki.books.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(String authorId);
    Author saveAuthor(String name, String bio, String email);
    void deleteAuthor(String authorId);
}