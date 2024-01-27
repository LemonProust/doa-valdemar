package ulht.doa.DTO;

import ulht.doa.entities.ClientEntity;
import ulht.doa.entities.ItemEntity;
import ulht.doa.entities.MovieEntity;

import java.util.Objects;

public class ItemDTO {
    private Long id;
    private int movieCod;
    private int clientCod;
    private double price;
    private String mediaType;
    private String rentalDate;
    private String returnDate;
    private MovieEntity movieEntity;
    private ClientEntity clientEntity;

    // Empty class constructor
    public ItemDTO(){}

    // Class constructor with references to Item Entity
    public ItemDTO(ItemEntity itemEntity){
        this.id = itemEntity.getId();
        this.movieCod = itemEntity.getMovieCod();
        this.clientCod = itemEntity.getClientCod();
        this.price = itemEntity.getPrice();
        this.mediaType = itemEntity.getMediaType();
        this.rentalDate = itemEntity.getRentalDate();
        this.returnDate = itemEntity.getReturnDate();
        this.movieEntity = itemEntity.getMovieEntity();
        this.clientEntity = itemEntity.getClientEntity();
    }

    //Getters & Setters

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

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    //Hush & Eguals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
