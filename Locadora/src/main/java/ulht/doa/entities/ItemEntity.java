package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;

@Introspected
@Entity
@Table(name = "ItemTB")
public class ItemEntity {
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
    @JoinColumn(name = "mpvieCod")
    private MovieEntity movieEntity;


//    @ManyToOne
//    @JoinColumn(name = "clientCod")
//    private ClientEntity clientEntity;

    // Empty constructor
    public ItemEntity(){}

    // Class constructor
    public ItemEntity(Long id, int movieCod, int clientCod, double price, String mediaType, String rentalDate, String returnDate, MovieEntity movieEntity) {
        this.id = id;
        this.movieCod = movieCod;
        this.clientCod = clientCod;
        this.price = price;
        this.mediaType = mediaType;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.movieEntity = movieEntity;
        //this.clientEntity = clientEntity;
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

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }

//    public ClientEntity getClientEntity() {
//        return clientEntity;
//    }
//
//    public void setClientEntity(ClientEntity clientEntity) {
//        this.clientEntity = clientEntity;
//    }
}
