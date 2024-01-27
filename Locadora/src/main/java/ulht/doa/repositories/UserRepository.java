package ulht.doa.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ulht.doa.entities.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
gi