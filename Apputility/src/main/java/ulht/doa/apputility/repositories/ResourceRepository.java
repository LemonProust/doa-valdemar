package ulht.doa.apputility.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ulht.doa.apputility.entities.ResourceEntity;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
