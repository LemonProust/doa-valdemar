package ulht.doa.apputility.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ulht.doa.apputility.entities.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
