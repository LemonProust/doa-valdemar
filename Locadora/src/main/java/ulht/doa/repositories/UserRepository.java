package ulht.doa.repositories;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ulht.doa.entities.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
