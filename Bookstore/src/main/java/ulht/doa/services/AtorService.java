package ulht.doa.services;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import ulht.doa.entities.Ator;
import ulht.doa.repositories.AtorRepository;

import java.util.List;

@Singleton
public class AtorService {

    private final AtorRepository atorRepository;

    public AtorService(AtorRepository atorRepository) {
        this.atorRepository = atorRepository;
    }

    @Transactional
    public List<Ator> getAllAtors() {
        return atorRepository.findAll();
    }

    public Ator saveAtor(Ator ator) {
        return atorRepository.save(ator);
    }

    public Ator findAtorByID(Long atorID) {
        return atorRepository.findById(atorID).get();
    }
}
