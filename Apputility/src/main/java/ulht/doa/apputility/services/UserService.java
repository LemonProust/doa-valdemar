package ulht.doa.apputility.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulht.doa.apputility.DTO.UserDTO;
import ulht.doa.apputility.entities.UserEntity;
import ulht.doa.apputility.repositories.UserRepository;

import java.util.List;
@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method responsible for get all Users in the Table UsersTB
    public List<UserDTO> getAllUsers(){
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity.stream().map(UserDTO::new).toList();
    }

    // Method responsible for get a selected User by id
    public UserDTO getUserById(Long id){
        return new UserDTO(userRepository.findById(id).get());
    }

    // Method responsible for insert values to the User's Table
    public void insert(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    // Method responsible for update user
    public UserDTO update(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO);
        return new UserDTO(userRepository.save(userEntity));
    }

    // Method responsible for DELETE user
    public void delete(Long id){
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }
}