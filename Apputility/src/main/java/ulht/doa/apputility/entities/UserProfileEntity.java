package ulht.doa.apputility.entities;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import ulht.doa.apputility.DTO.UserProfileDTO;

import java.util.Objects;

@Entity
@Table(name = "UserProfileTB")
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private ProfileEntity profileEntity;

    public UserProfileEntity() {
    }

    public UserProfileEntity(UserProfileDTO userProfileDTO) {
        BeanUtils.copyProperties(userProfileDTO, this);
        if (userProfileDTO != null && userProfileDTO.getUserDTO() != null){
            this.userEntity = new UserEntity(userProfileDTO.getUserDTO());
        }
        if (userProfileDTO != null && userProfileDTO.getProfileDTO() != null){
            this.profileEntity = new ProfileEntity(userProfileDTO.getProfileDTO());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileEntity that = (UserProfileEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
