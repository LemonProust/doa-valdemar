package ulht.doa.services;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import ulht.doa.entities.Author;
import ulht.doa.repositories.AuthorRepository;

import java.util.List;

@Singleton
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author findAuthorByID(Long authorID) {
        return authorRepository.findById(authorID).get();
    }

}