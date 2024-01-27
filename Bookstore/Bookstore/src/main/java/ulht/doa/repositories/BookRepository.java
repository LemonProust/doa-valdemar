package ulht.doa.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ulht.doa.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}