package mk.ukim.finki.books.repository;

import mk.ukim.finki.books.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
