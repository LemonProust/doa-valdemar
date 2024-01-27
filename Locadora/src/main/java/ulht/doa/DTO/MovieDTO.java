package ulht.doa.DTO;

import jakarta.persistence.OneToMany;
import ulht.doa.entities.ActorEntity;
import ulht.doa.entities.ItemEntity;
import ulht.doa.entities.MovieEntity;

import java.util.List;
import java.util.Objects;

public class MovieDTO {
    private Long id;
    private String title;
    private String genre;
    private int synopsis;
    private int duration;
    private List<ActorEntity> actorEntity;
    private List<ItemEntity> itemEntity;

    // Empty class constructor
    public MovieDTO(){}
    public MovieDTO(MovieEntity movieEntity){
        this.id = movieEntity.getId();
        this.title = movieEntity.getTitle();
        this.genre = movieEntity.getGenre();
        this.synopsis = movieEntity.getSynopsis();
        this.duration = movieEntity.getDuration();
        this.actorEntity = movieEntity.getActorsEntity();
        this.itemEntity = movieEntity.getItemEntity();
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

    public List<ActorEntity> getActorEntity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(id, movieDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
