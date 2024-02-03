package ulht.doa.apputility.services;

import org.springframework.stereotype.Service;
import ulht.doa.apputility.DTO.UserProfileDTO;
import ulht.doa.apputility.entities.UserProfileEntity;
import ulht.doa.apputility.repositories.UserProfileRepository;

import java.util.List;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;


    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    // Method responsible for get all Users in the Table UsersTB
    public List<UserProfileDTO> getAllUserProfiles(){
        List<UserProfileEntity> userProfileEntity = userProfileRepository.findAll();
        return userProfileEntity.stream().map(UserProfileDTO::new).toList();
    }

    // Method responsible for get a selected User by id
    public UserProfileDTO getUserProfileById(Long id){
        return new UserProfileDTO(userProfileRepository.findById(id).get());
    }

    // Method responsible for insert values to the User's Table
    public void saveUserProfile(UserProfileDTO userProfileDTO){
        UserProfileEntity userProfileEntity = new UserProfileEntity(userProfileDTO);
        userProfileRepository.save(userProfileEntity);
    }

    // Method responsible for update user
    public UserProfileDTO updateUserProfile(UserProfileDTO userProfileDTO){
        UserProfileEntity userProfileEntity = new UserProfileEntity(userProfileDTO);
        return new UserProfileDTO(userProfileRepository.save(userProfileEntity));
    }

    // Method responsible for DELETE user
    public void deleteUserProfile(Long id){
        UserProfileEntity userProfileEntity = userProfileRepository.findById(id).get();
        userProfileRepository.delete(userProfileEntity);
    }
}
