package ulht.doa.services;

import java.util.List;
import java.util.Optional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import ulht.doa.entities.*;
import ulht.doa.repositories.*;

@Singleton
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public List<Filme> listarFilmes() {
        return (List<Filme>) filmeRepository.findAll();
    }

    public Optional<Filme> buscarFilmePorId(Long id) {
        return filmeRepository.findById(id);
    }

    @Transactional
    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }

    // Adicione métodos específicos, se necessário
}
