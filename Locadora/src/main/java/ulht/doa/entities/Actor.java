package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Introspected
@Entity
@Table
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    private List<Movie> movies;

}
