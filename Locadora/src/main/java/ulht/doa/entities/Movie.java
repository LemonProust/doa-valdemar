package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;
import java.util.List;

@Introspected
@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private int sinopse;
    private int duration;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private List<Actor> actors;
    @OneToMany(mappedBy = "movieCod", cascade = CascadeType.ALL)
    private List<Item> items;

}
