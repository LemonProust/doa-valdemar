package ulht.doa.apputility.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulht.doa.apputility.DTO.ProfileDTO;
import ulht.doa.apputility.DTO.ResourceDTO;
import ulht.doa.apputility.services.ResourceService;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ResourceService resourceService;

    public List<ResourceDTO> getAllResources(){
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public ResourceDTO getResourceById(@PathVariable("id") Long id){
        return resourceService.getResourceById(id);
    }

    @PostMapping
    public void saveResource(@RequestBody ResourceDTO resourceDTO){
        resourceService.saveResource(resourceDTO);
    }

    @PutMapping
    public ResourceDTO updateResource(@RequestBody ResourceDTO resourceDTO){
        return resourceService.updateResource(resourceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable("id") Long id){
        resourceService.deleteResource(id);
        return ResponseEntity.ok().build();
    }

}
