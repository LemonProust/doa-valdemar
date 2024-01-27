package entity;

import enums.Genre;
import interfaces.Downloadable;
import interfaces.Book;

public class DigitalBook extends Book implements Downloadable {
    private String url;
    private double tamanhoMB;

    public DigitalBook(Author author, String title, int id, double price, Genre genre, String url, double sizeMB) {
        super(author, title, id, price, genre);
        this.url = url;
        this.tamanhoMB = sizeMB;
    }

    @Override
    public String tipoLivro() {
        return "Digital";
    }

    @Override
    public String getURL() {
        return url;
    }

    @Override
    public double sizeMB() {
        return tamanhoMB;
    }
}