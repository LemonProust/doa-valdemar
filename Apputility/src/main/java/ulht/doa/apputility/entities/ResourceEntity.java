package ulht.doa.apputility.entities;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import ulht.doa.apputility.DTO.ResourceDTO;

import java.util.Objects;

@Entity
@Table(name = "ResourceTB")
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String key;

    public ResourceEntity(){}

    public ResourceEntity(ResourceDTO resourceDTO) {
        BeanUtils.copyProperties(resourceDTO, this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntity that = (ResourceEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
