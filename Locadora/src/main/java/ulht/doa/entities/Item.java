package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;

import java.util.List;

@Introspected
@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int movieCod;
    private int clientCod;
    private double price;
    private String mediaType;
    private String rentalDate;
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movies;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client clients;

    // Empty constructor
    public Item(){}

    public Item(Long id, int movieCod, int clientCod, double price, String mediaType, String rentalDate, String returnDate, Movie movies, Client clients) {
        this.id = id;
        this.movieCod = movieCod;
        this.clientCod = clientCod;
        this.price = price;
        this.mediaType = mediaType;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.movies = movies;
        this.clients = clients;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMovieCod() {
        return movieCod;
    }

    public void setMovieCod(int movieCod) {
        this.movieCod = movieCod;
    }

    public int getClientCod() {
        return clientCod;
    }

    public void setClientCod(int clientCod) {
        this.clientCod = clientCod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Movie getMovies() {
        return movies;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }
}
