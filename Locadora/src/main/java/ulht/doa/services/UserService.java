package ulht.doa.services;


import jakarta.inject.Singleton;
import ulht.doa.DTO.UserDTO;
import ulht.doa.entities.UserEntity;
import ulht.doa.repositories.UserRepository;

import java.util.List;

@Singleton
public class UserService {

    // Object repository
    private UserRepository userRepository;

    // Method responsible for get all Users
    public List<UserDTO> getAllUsers(){
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity.stream().map(UserDTO::new).toList();
    }

    // Method responsible for create User
    public void insert(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    // Method responsible for update data
    public UserDTO update(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO);
        return new UserDTO(userRepository.save(userEntity));
    }

    // Method responsible for DELETE user
    public void delete(Long id){
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }

    // Method responsible for get user by id
    public UserDTO findUserById(Long id){
        return new UserDTO(userRepository.findById(id).get());
    }
}
