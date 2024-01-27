package ulht.doa.DTO;

import io.micronaut.serde.annotation.Serdeable;
import ulht.doa.entities.Book;

@Serdeable
public class BookDTO {

    private Long id;
    private String title;
    private String authorName;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorName = book.getAuthor().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + authorName + '\'' +
                '}';
    }
}
