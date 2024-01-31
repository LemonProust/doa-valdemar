package ulht.doa.apputility.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulht.doa.apputility.DTO.ProfileDTO;
import ulht.doa.apputility.services.ProfileService;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<ProfileDTO> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ProfileDTO getProfileById(@PathVariable("id") Long id){
        return profileService.getProfileById(id);
    }

    @PostMapping
    public void saveProfile(@RequestBody ProfileDTO profileDTO){
        profileService.saveProfile(profileDTO);
    }

    @PutMapping
    public ProfileDTO updateProfile(@RequestBody ProfileDTO profileDTO){
        return profileService.updateProfile(profileDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable("id") Long id){
        profileService.deleteProfile(id);
        return ResponseEntity.ok().build();
    }

}
