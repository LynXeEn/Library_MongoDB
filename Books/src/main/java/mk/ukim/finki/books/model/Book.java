package mk.ukim.finki.books.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Book {

    @Id
    private String id;

    private String title;
    private String isbn;
    private int publishedYear;

    @DBRef
    private Author author;

    public Book() {
    }

    public Book(String title, String isbn, int publishedYear, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.author = author;
    }
}