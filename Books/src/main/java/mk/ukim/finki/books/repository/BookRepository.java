package mk.ukim.finki.books.repository;

import mk.ukim.finki.books.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book, String> {
}
