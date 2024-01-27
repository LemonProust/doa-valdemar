package ulht.doa.repositories;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.context.annotation.Parameter;
import ulht.doa.entities.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    // Find users by id
    @Query("SELECT a FROM UserEntity a WHERE a.id = :id")
    List<UserEntity> findUsersById(Long id);

    // Find users by name
    @Query("SELECT a FROM UserEntity a WHERE a.name = :name")
    List<UserEntity> findUsersByName(String name);

    // Find user whose name starts with a
    @Query("SELECT a FROM UserEntity a WHERE LOWER(a.name) LIKE 'a%'")
    List<UserEntity> findUsersWhoseNamesStartWithA();

    @Query("SELECT a FROM UserEntity a WHERE a.email = :email")
    List<UserEntity> findUsersByEmail(String email);

//    @Query("SELECT a FROM UserEntity a WHERE size(a.books) > :minBookCount")
//    List<UserEntity> findAuthorsWithMinBooks(@Parameter("minBookCount") int minBookCount);


}