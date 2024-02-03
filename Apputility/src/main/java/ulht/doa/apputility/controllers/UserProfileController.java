package ulht.doa.apputility.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulht.doa.apputility.DTO.UserProfileDTO;
import ulht.doa.apputility.services.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/userprofile")
@CrossOrigin
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfileDTO> getAllUserProfiles(){
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping("/{id}")
    public UserProfileDTO getProfileById(@PathVariable("id") Long id){
        return userProfileService.getUserProfileById(id);
    }

    @PostMapping
    public void saveProfile(@RequestBody UserProfileDTO userProfileDTO){
        userProfileService.saveUserProfile(userProfileDTO);
    }

    @PutMapping
    public UserProfileDTO updateProfile(@RequestBody UserProfileDTO userProfileDTO){
        return userProfileService.updateUserProfile(userProfileDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable("id") Long id){
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.ok().build();
    }
}
