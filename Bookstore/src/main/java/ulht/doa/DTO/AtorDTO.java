package ulht.doa.DTO;

import io.micronaut.serde.annotation.Serdeable;
import ulht.doa.entities.Ator;
import ulht.doa.entities.Author;


@Serdeable
public class AtorDTO {
    private Long id;
    private String nome;
    private String nacionalidade;

    // Construtores
    public AtorDTO() {
    }

    public AtorDTO(Ator ator) {
        this.id = ator.getId();
        this.nome = ator.getNome();
        this.nacionalidade = ator.getNacionalidade();
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "AtorDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}

