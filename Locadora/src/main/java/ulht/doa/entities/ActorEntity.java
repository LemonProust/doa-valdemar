package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;

import java.util.List;

@Introspected
@Entity
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    @ManyToMany(mappedBy = "actorEntity", cascade = CascadeType.ALL)
    private List<MovieEntity> movieEntity;

    // Empty method constructor
    public ActorEntity(){}

    // Method constructor
    public ActorEntity(Long id, String name, String nationality, List<MovieEntity> movieEntity) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.movieEntity = movieEntity;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<MovieEntity> getMoviesEntity() {
        return movieEntity;
    }

    public void setMoviesEntity(List<MovieEntity> movieEntity) {
        this.movieEntity = movieEntity;
    }
}
