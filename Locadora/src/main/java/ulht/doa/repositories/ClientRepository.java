package ulht.doa.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ulht.doa.entities.ClientEntity;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

}
