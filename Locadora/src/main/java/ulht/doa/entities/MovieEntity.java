package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;
import java.util.List;

@Introspected
@Entity
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private int sinopse;
    private int duration;

    @ManyToMany(mappedBy = "movieEntity")
    private List<ActorEntity> actorEntity;

    // Empty constructor
    public MovieEntity(){}

    // Class constructor
    public MovieEntity(Long id, String title, String genre, int sinopse, int duration, List<ActorEntity> actorEntity) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.sinopse = sinopse;
        this.duration = duration;
        this.actorEntity = actorEntity;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSinopse() {
        return sinopse;
    }

    public void setSinopse(int sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<ActorEntity> getActorsEntity() {
        return actorEntity;
    }

    public void setActorEntity(List<ActorEntity> actorEntity) {
        this.actorEntity = actorEntity;
    }


}
