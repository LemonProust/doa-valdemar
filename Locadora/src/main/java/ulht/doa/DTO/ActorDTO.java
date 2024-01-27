package ulht.doa.DTO;

import ulht.doa.entities.ActorEntity;
import ulht.doa.entities.MovieEntity;

import java.util.List;
import java.util.Objects;

public class ActorDTO {
    private Long id;
    private String name;
    private String nationality;
    private List<MovieEntity> movieEntity;

    // Empty class constructor
    public ActorDTO(){}

    // Class constructor with reference on Actor Entity
    public ActorDTO(ActorEntity actorEntity) {
        this.id = actorEntity.getId();
        this.name = actorEntity.getName();
        this.nationality = actorEntity.getNationality();
        this.movieEntity = actorEntity.getMovieEntity();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDTO actorDTO = (ActorDTO) o;
        return Objects.equals(id, actorDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
