package ulht.doa.apputility.entities;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import ulht.doa.apputility.DTO.ProfileDTO;

import java.util.Objects;

@Entity
@Table(name = "ProfileTB")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String description;

    // Empty constructor for jakarta annotation
    public ProfileEntity(){}

    // Method constructor responsible for build and initialize the object
    public ProfileEntity(ProfileDTO profileDTO) {
        BeanUtils.copyProperties(profileDTO, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileEntity that = (ProfileEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
