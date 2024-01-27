package ulht.doa.startup;
import ulht.doa.entities.Author;
import ulht.doa.entities.Book;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;
import ulht.doa.services.AuthorService;
import ulht.doa.services.BookService;

@Singleton
public class StartupInitializer implements ApplicationEventListener<ServerStartupEvent> {

    private final AuthorService authorService;
    private final BookService bookService;

    public StartupInitializer(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        Author author1 = new Author();
        author1.setName("John Doe");
        authorService.saveAuthor(author1);

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setAuthor(author1);
        bookService.saveBook(book1);

        Author author2 = new Author();
        author2.setName("Jane Doe");
        authorService.saveAuthor(author2);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setAuthor(author2);
        bookService.saveBook(book2);
    }
}
