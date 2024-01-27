package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;
import ulht.doa.DTO.MovieDTO;

import java.util.List;

@Introspected
@Entity
@Table(name = "MovieTB")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private int synopsis;
    private int duration;

    @ManyToMany(mappedBy = "movieEntity")
    private List<ActorEntity> actorEntity;
    @OneToMany(mappedBy = "movieEntity")
    private List<ItemEntity> itemEntity;

    // Empty constructor
    public MovieEntity(){}

    // Class constructor
    public MovieEntity(MovieDTO movieDTO) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.synopsis = synopsis;
        this.duration = duration;
        this.actorEntity = actorEntity;
        this.itemEntity = itemEntity;
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

    public int getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(int synopsis) {
        this.synopsis = synopsis;
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

    public List<ItemEntity> getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(List<ItemEntity> itemEntity) {
        this.itemEntity = itemEntity;
    }
}
