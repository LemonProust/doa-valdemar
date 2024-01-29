package ulht.doa.apputility.DTO;

import org.springframework.beans.BeanUtils;
import ulht.doa.apputility.entities.ResourceEntity;

public class ResourceDTO {
    private Long id;
    private String name;
    private String key;
    public ResourceDTO(){}

    public ResourceDTO(ResourceEntity resourceEntity) {
        BeanUtils.copyProperties(resourceEntity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
