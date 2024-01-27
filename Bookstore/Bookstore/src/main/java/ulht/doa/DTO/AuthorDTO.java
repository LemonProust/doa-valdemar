package ulht.doa.DTO;

import io.micronaut.serde.annotation.Serdeable;
import ulht.doa.entities.Author;

@Serdeable
public class AuthorDTO {

    private Long id;
    private String name;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
    }

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
    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
