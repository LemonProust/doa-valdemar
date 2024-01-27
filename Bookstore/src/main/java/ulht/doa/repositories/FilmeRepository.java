package ulht.doa.repositories;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import ulht.doa.entities.Filme;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Long> {
    // Adicione consultas específicas, se necessário

    @Query("SELECT f FROM Filme f WHERE f.id = :id")
    List<Filme> findFilmeById(String id);

    @Query("SELECT f FROM Filme f WHERE LOWER(f.titulo) LIKE 'a%'")
    List<Filme> findFilmesWhoseNamesStartWithA();
}
