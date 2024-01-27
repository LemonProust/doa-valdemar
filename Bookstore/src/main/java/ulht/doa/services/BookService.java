package ulht.doa.services;// BookService.java
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import ulht.doa.entities.Book;
import ulht.doa.repositories.BookRepository;

import java.util.List;

@Singleton
public class BookService {

    @Inject
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // other book-related methods
}