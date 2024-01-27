package ulht.doa.DTO;

import jakarta.persistence.OneToMany;
import ulht.doa.entities.ActorEntity;
import ulht.doa.entities.ItemEntity;

import java.util.List;

public class MovieDTO {
    private Long id;
    private String title;
    private String genre;
    private int sinopse;
    private int duration;
    private List<ActorEntity> actorEntity;
    private List<ItemEntity> itemEntity;
}
