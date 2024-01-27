package ulht.doa.DTO;

import ulht.doa.entities.ActorEntity;
import ulht.doa.entities.MovieEntity;

import java.util.List;

public class ActorDTO {
    private Long id;
    private String name;
    private String nationality;
    private List<MovieEntity> movieEntity;

    // Empty class constructor
    public ActorDTO(){}

    // Class constructor

    public ActorDTO(ActorEntity actorEntity) {
        this.id = actorEntity.getId();
        this.name = actorEntity.getName();
        this.nationality = actorEntity.getNationality();
        this.movieEntity = actorEntity.getMovieEntity();
    }
}
