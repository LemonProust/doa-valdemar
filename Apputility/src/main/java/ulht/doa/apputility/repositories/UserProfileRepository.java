package ulht.doa.apputility.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ulht.doa.apputility.entities.UserProfileEntity;

@Repository
public interface UserProfileRepository extends JpaRepository <UserProfileEntity, Long> {
}
