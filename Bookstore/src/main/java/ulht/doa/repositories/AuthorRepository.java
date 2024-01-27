package ulht.doa.repositories;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import ulht.doa.entities.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.name = :name")
    List<Author> findAuthorsByName(String name);

    @Query("SELECT a FROM Author a WHERE size(a.books) > :minBookCount")
    List<Author> findAuthorsWithMinBooks(@Parameter("minBookCount") int minBookCount);

    @Query("SELECT a FROM Author a WHERE LOWER(a.name) LIKE 'a%'")
    List<Author> findAuthorsWhoseNamesStartWithA();
}
