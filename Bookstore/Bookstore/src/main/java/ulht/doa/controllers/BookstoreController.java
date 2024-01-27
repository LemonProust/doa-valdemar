package ulht.doa.controllers;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import ulht.doa.DTO.AuthorDTO;
import ulht.doa.DTO.BookDTO;
import ulht.doa.entities.Author;
import ulht.doa.entities.Book;
import ulht.doa.services.AuthorService;
import ulht.doa.services.BookService;

import java.util.stream.Collectors;

@Controller("/bookstore")
public class BookstoreController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookstoreController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Get("/books")
    public Iterable<BookDTO> getAllBooks() {
        // Convert entities to DTOs before returning
        return bookService.getAllBooks().stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    @Post("/books")
    public BookDTO saveBook(@Body BookDTO bookDTO, Long authorID) {
        // Convert DTO to entity before saving
        Book savedBook = bookService.saveBook(new Book(bookDTO.getTitle(),
                authorService.findAuthorByID(authorID)));
        return new BookDTO(savedBook);
    }

    @Get("/authors")
    public Iterable<AuthorDTO> getAllAuthors() {
        // Convert entities to DTOs before returning
        return authorService.getAllAuthors().stream()
                .map(AuthorDTO::new)
                .collect(Collectors.toList());
    }

    @Post("/authors")
    public AuthorDTO saveAuthor(@Body AuthorDTO authorDTO) {
        // Convert DTO to entity before saving
        Author savedAuthor = authorService.saveAuthor(new Author(authorDTO.getName()));
        return new AuthorDTO(savedAuthor);
    }
}
