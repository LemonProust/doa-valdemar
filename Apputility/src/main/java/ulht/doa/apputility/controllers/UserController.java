package ulht.doa.apputility.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ulht.doa.apputility.DTO.UserDTO;
import ulht.doa.apputility.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    // @GET
    // Method responsible for getting all users
    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    //@POST
    // Method responsible for create User
    @PostMapping
    public void insert(@RequestBody UserDTO userDTO){
        userService.insert(userDTO);
    }

    //@PUT
    // Method responsible for update data
    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    //@DELETE
    // Method responsible for DELETE user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
