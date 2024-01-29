package ulht.doa.apputility.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulht.doa.apputility.DTO.ResourceDTO;
import ulht.doa.apputility.entities.ResourceEntity;
import ulht.doa.apputility.repositories.ResourceRepository;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    // Read all Users in the Table UsersTB
    public List<ResourceDTO> getAllResources(){
        List<ResourceEntity> resourceEntity = resourceRepository.findAll();
        return resourceEntity.stream().map(ResourceDTO::new).toList();
    }

    // Read a selected resource in the DB
    public ResourceDTO getResourceById(Long id){
        return new ResourceDTO(resourceRepository.findById(id).get());
    }

    // Method for insert values to the User's Table
    public void saveResource(ResourceDTO resourceDTO){
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        resourceRepository.save(resourceEntity);
    }

    // Method update
    public ResourceDTO updateResource(ResourceDTO resourceDTO){
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        return new ResourceDTO(resourceRepository.save(resourceEntity));
    }

    // Method for DELETE user
    public void deleteResource(Long id){
        ResourceEntity resourceEntity = resourceRepository.findById(id).get();
        resourceRepository.delete(resourceEntity);
    }

}
