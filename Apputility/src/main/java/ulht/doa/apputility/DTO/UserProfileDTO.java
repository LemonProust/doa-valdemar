package ulht.doa.apputility.DTO;


import org.springframework.beans.BeanUtils;
import ulht.doa.apputility.entities.ProfileEntity;
import ulht.doa.apputility.entities.UserEntity;
import ulht.doa.apputility.entities.UserProfileEntity;

public class UserProfileDTO {
    private Long id;
    private UserDTO userDTO;
    private ProfileDTO profileDTO;

    public UserProfileDTO() {
    }

    public UserProfileDTO(UserProfileEntity userProfileEntity) {
        BeanUtils.copyProperties(userProfileEntity, this);
        if(userProfileEntity != null && userProfileEntity.getUserEntity() !=null){
            this.userDTO = new UserDTO(userProfileEntity.getUserEntity());
        }
        if (userProfileEntity != null && userProfileEntity.getProfileEntity()!=null){
            this.profileDTO = new ProfileDTO(userProfileEntity.getProfileEntity());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }
}
