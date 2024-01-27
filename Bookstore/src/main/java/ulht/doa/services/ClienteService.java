package ulht.doa.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import ulht.doa.entities.Author;
import ulht.doa.entities.Cliente;
import ulht.doa.repositories.ClienteRepository;
import java.util.List;

@Singleton
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }


    @Transactional
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Adicione métodos específicos, se necessário
}
