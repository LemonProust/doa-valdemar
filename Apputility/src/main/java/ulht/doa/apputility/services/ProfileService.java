package ulht.doa.apputility.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulht.doa.apputility.DTO.ProfileDTO;
import ulht.doa.apputility.entities.ProfileEntity;
import ulht.doa.apputility.repositories.ProfileRepository;

import java.util.List;
@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    // Read all Users in the Table
    public List<ProfileDTO> getAllProfiles(){
        List<ProfileEntity> resourceEntity = profileRepository.findAll();
        return resourceEntity.stream().map(ProfileDTO::new).toList();
    }

    // Read a selected resource in the DB
    public ProfileDTO getProfileById(Long id){
        return new ProfileDTO(profileRepository.findById(id).get());
    }

    // Method for insert values
    public void saveProfile(ProfileDTO profileDTO){
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        profileRepository.save(profileEntity);
    }

    // Method update
    public ProfileDTO updateProfile(ProfileDTO profileDTO){
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        return new ProfileDTO(profileRepository.save(profileEntity));
    }

    // Method for DELETE
    public void deleteProfile(Long id){
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
    }
}
