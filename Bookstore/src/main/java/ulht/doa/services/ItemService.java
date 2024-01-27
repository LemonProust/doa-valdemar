package ulht.doa.services;
import java.util.List;
import java.util.Optional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import ulht.doa.entities.*;
import ulht.doa.repositories.*;

@Singleton
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Item salvarItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> listarItens() {
        return (List<Item>) itemRepository.findAll();
    }

    public Optional<Item> buscarItemPorId(Long id) {
        return itemRepository.findById(id);
    }

    @Transactional
    public void deletarItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Adicione métodos específicos, se necessário
}
