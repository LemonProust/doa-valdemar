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

    // Empty method constructor
    public Actor(){}

    // Method constructor
    public Actor(Long id, String name, String nationality, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.movies = movies;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
