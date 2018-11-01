package roshan.learning.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import roshan.learning.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
