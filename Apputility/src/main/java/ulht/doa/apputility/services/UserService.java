package ulht.doa.apputility.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulht.doa.apputility.DTO.UserDTO;
import ulht.doa.apputility.entities.UserEntity;
import ulht.doa.apputility.repositories.UserRepository;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Read all Users in the Table UsersTB
    public List<UserDTO> getAllUsers(){
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity.stream().map(UserDTO::new).toList();
    }

    // Read a selected User in the Table UsersTB
    public UserDTO getUserById(Long id){
        return new UserDTO(userRepository.findById(id).get());
    }

    // Method for insert values to the User's Table
    public void insert(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    // Method update
    public UserDTO update(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO);
        return new UserDTO(userRepository.save(userEntity));
    }

    // Method for DELETE user
    public void delete(Long id){
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }
}