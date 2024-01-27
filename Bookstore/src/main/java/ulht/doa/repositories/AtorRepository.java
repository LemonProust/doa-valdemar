package ulht.doa.repositories;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import ulht.doa.entities.Ator;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Long> {

    @Query("SELECT a FROM Ator a WHERE a.nome = :name")
    List<Ator> findAtoresByName(String name);

    @Query("SELECT a FROM Ator a WHERE size(a.filmes) > :minFilmesCount")
    List<Ator> findAtoresWithMinFilmes(@Parameter("minFilmesCount") int minFilmesCount);

    @Query("SELECT a FROM Ator a WHERE LOWER(a.nome) LIKE 'a%'")
    List<Ator> findAuthorsWhoseNamesStartWithA();
}

