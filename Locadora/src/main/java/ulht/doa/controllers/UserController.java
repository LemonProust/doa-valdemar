package ulht.doa.controllers;


import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import ulht.doa.DTO.UserDTO;
import ulht.doa.services.UserService;

//import java.net.http.HttpResponse;
import java.util.List;

@Controller("/user")
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService){
        this.userService = userService;
    }
    // @GET
    // Method responsible for getting all users
    @Get()
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    //@POST
    // Method responsible for create User
    @Post
    public void insert(@Body UserDTO userDTO){
        userService.insert(userDTO);
    }

    //@PUT
    // Method responsible for update data
    @Put("/{id}")
    public UserDTO update(@PathVariable("id") Long id, @Body UserDTO userDTO){
        return userService.update(userDTO);
    }

    //@DELETE
    // Method responsible for DELETE user
    @Delete("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
        System.out.println(id+" deleted successfully!");
    }

//    @Delete("/{id}")
//    public HttpResponse delete(@PathVariable Long id){
//        userService.delete(id);
//        return HttpResponse.ok();
//    }

}