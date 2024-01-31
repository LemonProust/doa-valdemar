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

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // @GET
    // Method responsible for getting all Users
    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    // @GET
    // Method responsible for getting a user
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    //@POST
    // Method responsible for create User
    @PostMapping
    public void insert(@RequestBody UserDTO userDTO){
        userService.insert(userDTO);
    }

    //@PUT
    // Method responsible for update User data
    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    //@DELETE
    // Method responsible for DELETE User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
