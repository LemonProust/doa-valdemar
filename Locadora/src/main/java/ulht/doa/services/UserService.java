package ulht.doa.services;

import io.micronaut.data.annotation.AutoPopulated;
import jakarta.inject.Singleton;
import org.hibernate.service.JavaServiceLoadable;
import ulht.doa.DTO.UserDTO;
import ulht.doa.entities.UserEntity;
import ulht.doa.repositories.UserRepository;

import java.util.List;

@Singleton
public class UserService {

    private UserRepository userRepository;

    // Read all Users inthe Table UsersTB
    public List<UserDTO> listAll(){
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity.stream().map(UserDTO::new).toList();
    }

    // Method for insert values to the User's Table
    public void insert(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO.getId(), userDTO.getName(),userDTO.getLoginName(),userDTO.getEmail(), userDTO.getPasswd());
        userRepository.save(userEntity);
    }

    // Method update
    public UserDTO update(UserDTO userDTO){
        UserEntity userEntity = new UserEntity(userDTO.getId(), userDTO.getName(),userDTO.getLoginName(),userDTO.getEmail(), userDTO.getPasswd());
        return new UserDTO(userRepository.save(userEntity));
    }

    // Method for DELETE user
    public void delete(Long id){
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }
}
