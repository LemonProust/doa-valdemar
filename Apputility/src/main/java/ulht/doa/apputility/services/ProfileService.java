package ulht.doa.apputility.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulht.doa.apputility.DTO.ProfileDTO;
import ulht.doa.apputility.entities.ProfileEntity;
import ulht.doa.apputility.repositories.ProfileRepository;

import java.util.List;
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // Method responsible for Read all Users Profiles in the Table
    public List<ProfileDTO> getAllProfiles(){
        List<ProfileEntity> profileEntity = profileRepository.findAll();
        return profileEntity.stream().map(ProfileDTO::new).toList();
    }

    // Method responsible for Read a selected resource in the DB
    public ProfileDTO getProfileById(Long id){
        return new ProfileDTO(profileRepository.findById(id).get());
    }

    // Method responsible for CREATE Profiles kind
    public void saveProfile(ProfileDTO profileDTO){
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        profileRepository.save(profileEntity);
    }

    // Method responsible for UPDATE the Profile
    public ProfileDTO updateProfile(ProfileDTO profileDTO){
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        return new ProfileDTO(profileRepository.save(profileEntity));
    }

    // Method responsible for DELETE the Profile
    public void deleteProfile(Long id){
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
    }
}
