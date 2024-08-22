package mk.ukim.finki.books.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Author {

    @Id
    private String id;

    private String name;
    private String biography;
    private String email;


    public Author() {
    }

    public Author(String name, String biography, String email) {
        this.name = name;
        this.biography = biography;
        this.email = email;
    }
}