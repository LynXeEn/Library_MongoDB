package mk.ukim.finki.books.web.controller;

import mk.ukim.finki.books.model.Author;
import mk.ukim.finki.books.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String getAllAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "authors/list"; // Corresponding Thymeleaf view
    }


    @GetMapping("/new")
    public String showCreateAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form"; // Corresponding Thymeleaf view
    }

    @PostMapping
    public String createAuthor(@RequestParam String name,
                               @RequestParam String bio,
                               @RequestParam String email) {
        authorService.saveAuthor(name, bio, email);
        return "redirect:/authors";
    }



    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
}
