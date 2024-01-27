package interfaces;

import entity.Author;
import enums.Genre;

public abstract class Book {
    private Author author;
    private String title;
    private int id;
    private double price;
    private Genre genre;

    public Book(Author autor, String titulo, int livroId, double preco, Genre genero) {
        this.author = autor;
        this.title = titulo;
        this.id = livroId;
        this.price = preco;
        this.genre = genero;
    }

    public Author getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Genre getGenre(){
            return genre;
    }

    public abstract String tipoLivro();

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " Autor: "
                + author + " ID: " + id + " Preço: " + price + " Gênero: " + genre;
    }
}