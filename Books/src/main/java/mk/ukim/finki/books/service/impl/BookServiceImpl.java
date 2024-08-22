package mk.ukim.finki.books.service.impl;

import mk.ukim.finki.books.model.Author;
import mk.ukim.finki.books.model.Book;
import mk.ukim.finki.books.repository.AuthorRepository;
import mk.ukim.finki.books.repository.BookRepository;
import mk.ukim.finki.books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book saveBook(String title, String isbn, int publishedYear, String authorId) {
        Author author = authorRepository.findById(authorId).get();
        Book book = new Book(title, isbn, publishedYear, author);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
