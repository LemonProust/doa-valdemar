package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;

@Introspected
@Entity
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public LocationEntity(){}
}
