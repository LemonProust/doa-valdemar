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

    // Empty constructor
    public Movie(){}

    // Class constructor
    public Movie(Long id, String title, String genre, int sinopse, int duration, List<Actor> actors, List<Item> items) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.sinopse = sinopse;
        this.duration = duration;
        this.actors = actors;
        this.items = items;
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

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
