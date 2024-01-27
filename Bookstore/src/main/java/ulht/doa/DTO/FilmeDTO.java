package ulht.doa.DTO;

import io.micronaut.serde.annotation.Serdeable;
import ulht.doa.entities.Filme;

@Serdeable

public class FilmeDTO {
    private Long id;
    private String titulo;
    private String genero;
    private int duracao;
    private String sinopse;

    // Construtor vazio
    public FilmeDTO() {
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "FilmeDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao=" + duracao +
                ", sinopse='" + sinopse + '\'' +
                '}';
    }
}
