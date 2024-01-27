package ulht.doa.entities;

import jakarta.persistence.*;

import io.micronaut.core.annotation.Introspected;
import ulht.doa.DTO.ActorDTO;

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

    @ManyToMany(mappedBy = "actorEntity")
    private List<MovieEntity> movieEntity;

    public ActorEntity(){}

    public ActorEntity(ActorDTO actorDTO) {
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

    public List<MovieEntity> getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(List<MovieEntity> movieEntity) {
        this.movieEntity = movieEntity;
    }
}
