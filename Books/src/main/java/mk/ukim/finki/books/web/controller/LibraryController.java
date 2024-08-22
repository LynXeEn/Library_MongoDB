package mk.ukim.finki.books.web.controller;

import mk.ukim.finki.books.model.Library;
import mk.ukim.finki.books.service.BookService;
import mk.ukim.finki.books.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;
    private final BookService bookService;

    public LibraryController(LibraryService libraryService, BookService bookService) {
        this.libraryService = libraryService;
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllLibraries(Model model) {
        List<Library> libraries = libraryService.getAllLibraries();
        model.addAttribute("libraries", libraries);
        return "authors/libraryList"; // Thymeleaf template name
    }


    @GetMapping("/new")
    public String showCreateLibraryForm(Model model) {
        model.addAttribute("library", new Library());
        model.addAttribute("books", bookService.getAllBooks());
        // You may need to pass a list of books if relevant
        return "authors/libraryForm"; // Thymeleaf template name for the form
    }

    @PostMapping
    public String createLibrary(@RequestParam String name,
                                @RequestParam boolean wirelessAccess,
                                @RequestParam List<String> bookIds) {
        libraryService.saveLibrary(name, wirelessAccess, bookIds);
        return "redirect:/libraries"; // Redirect to the list page
    }

    @GetMapping("/delete/{id}")
    public String deleteLibrary(@PathVariable String id) {
        libraryService.deleteLibrary(id);
        return "redirect:/libraries";

    }
}
