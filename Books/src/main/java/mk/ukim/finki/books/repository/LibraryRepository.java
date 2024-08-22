package mk.ukim.finki.books.repository;

import mk.ukim.finki.books.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Library, String> {
}
