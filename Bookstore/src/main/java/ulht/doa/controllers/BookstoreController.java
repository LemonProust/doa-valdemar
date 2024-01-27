package ulht.doa.controllers;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import ulht.doa.DTO.*;
import ulht.doa.entities.*;
import ulht.doa.services.*;

import java.util.stream.Collectors;

@Controller("/bookstore")
public class BookstoreController {

    private final BookService bookService;
    private final AuthorService authorService;

    private final AtorService atorService;
    private final ClienteService clienteService;

    private final FilmeService filmeService;
    private final ItemService itemService;
    private final LocacaoService locacaoService;

    public BookstoreController(
            BookService bookService,
            AuthorService authorService,
            AtorService atorService,
            ClienteService clienteService,
            FilmeService filmeService,
            ItemService itemService,
            LocacaoService locacaoService
            ) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.atorService = atorService;
        this.clienteService = clienteService;
        this.filmeService = filmeService;
        this.itemService = itemService;
        this.locacaoService = locacaoService;
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

//    @Post("/ators")
//    public AtorDTO saveAtor(@Body AtorDTO atorDTO) {
//        // Convert DTO to entity before saving
//        Ator savedAtor = atorService.saveAtor(new Ator(atorDTO.getNome()));
//        return new AtorDTO(savedAtor);
//    }
//
//    @Post("/filmes")
//    public FilmeDTO saveFilme(@Body FilmeDTO filmeDTO) {
//        // Convert DTO to entity before saving
//        FilmeDTO savedFilme = filmeService.salvarFilme(new Filme(filmeDTO.getTitulo()));
//        return new filmeDTO(savedFilme);
//    }
}
