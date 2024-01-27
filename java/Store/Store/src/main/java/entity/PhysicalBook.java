package entity;

import enums.Genre;
import interfaces.Book;

public class PhysicalBook extends Book {
    private int nPages;

    public PhysicalBook(Author author, String title, int id, double price, Genre genre, int nPages) {
        super(author, title, id, price, genre);
        this.nPages = nPages;
    }

    @Override
    public String tipoLivro() {
        return "Physical";
    }
}