package ulht.doa.entities;

import jakarta.persistence.*;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
@Entity
@Table(name = "ActorTB")
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;


}
