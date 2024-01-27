package ulht.doa.repositories;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ulht.doa.entities.Cliente;

import java.util.List;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.nome = :name")
    List<Cliente> findClienteByName(String name);

    @Query("SELECT c FROM Cliente c WHERE size(c.items) > :minItemsCount")
    List<Cliente> findClienteWithItems(@Parameter("minItemsCount") int minItemsCount);

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE 'a%'")
    List<Cliente> findClienteWhoseNamesStartWithA();

}
