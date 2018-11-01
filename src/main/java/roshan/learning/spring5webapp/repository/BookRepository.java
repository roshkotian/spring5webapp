package roshan.learning.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import roshan.learning.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
