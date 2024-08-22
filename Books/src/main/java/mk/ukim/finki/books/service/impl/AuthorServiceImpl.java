package mk.ukim.finki.books.service.impl;

import mk.ukim.finki.books.model.Author;
import mk.ukim.finki.books.repository.AuthorRepository;
import mk.ukim.finki.books.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(String authorId) {
        return authorRepository.findById(authorId).get();
    }

    @Override
    public Author saveAuthor(String name, String bio, String email) {
        return authorRepository.save(new Author(name, bio, email));
    }

    @Override
    public void deleteAuthor(String authorId) {
        authorRepository.deleteById(authorId);
    }
}
