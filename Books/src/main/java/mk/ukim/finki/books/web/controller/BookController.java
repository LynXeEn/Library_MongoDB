package mk.ukim.finki.books.web.controller;

import mk.ukim.finki.books.model.Book;
import mk.ukim.finki.books.service.AuthorService;
import mk.ukim.finki.books.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "authors/bookList";
    }

    @GetMapping("/new")
    public String showCreateBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors/bookForm";
    }

    @PostMapping
    public String createBook(@RequestParam String title,
                             @RequestParam String isbn,
                             @RequestParam int publishedYear,
                             @RequestParam String authorId) {
        bookService.saveBook(title, isbn, publishedYear, authorId);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
