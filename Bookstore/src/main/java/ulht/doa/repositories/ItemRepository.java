package ulht.doa.repositories;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import ulht.doa.entities.Item;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    // Consultar o tipo de midias
    @Query("SELECT i FROM Item i WHERE i.tipoMidia = :tipoMidia")
    List<Item> findByTipoMidia(@Parameter("tipoMidia") String tipoMidia);

    // Consultar
    @Query("SELECT i FROM Item i WHERE i.filme = :filme")
    List<Item> findByFilme(@Parameter("filme") String filme);

}

