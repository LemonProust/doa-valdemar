package ulht.doa.apputility.DTO;

import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;
import ulht.doa.apputility.entities.ProfileEntity;

public class ProfileDTO {
    private Long id;
    private String description;

    public ProfileDTO() {

    }

    // Method constructor responsible for build and initialize the object
    public ProfileDTO(ProfileEntity profileEntity) {
        BeanUtils.copyProperties(profileEntity, this);
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
}
