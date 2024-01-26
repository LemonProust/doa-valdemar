package ulht.doa.controllers;

import io.micronaut.context.annotation.Mapper;
import io.micronaut.http.annotation.*;
import ulht.doa.DTO.UserDTO;
import ulht.doa.services.UserService;

import java.util.List;

@Controller("/user")
public class UserController {

    private UserService userService;

    // @GET
    // MEthod responsible for getting all users
    @Mapper
    @Get()
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    //@POST
    // Method responsible for create User
    @Post
    public void insert(UserDTO userDTO){
        userService.insert(userDTO);
    }

    //@PUT
    // Method responsible for update data
    @Put
    public UserDTO update(UserDTO userDTO){
        return userService.update(userDTO);
    }

    //@DELETE
    // Method responsible for DELETE user
    @Delete
    public void delete(Long id){
        userService.delete(id);
    }

}
