package mk.ukim.finki.books.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Library {

    @Id
    private String id;

    private String name;
    private boolean wirelessAccess = false;

    private List<Book> books;

    public Library(String name, boolean wirelessAccess, List<Book> books) {
        this.name = name;
        this.wirelessAccess = wirelessAccess;
        this.books = books;
    }

    public Library() {

    }
}
