package ulht.doa.apputility.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulht.doa.apputility.DTO.ResourceDTO;
import ulht.doa.apputility.services.ResourceService;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {

    private final ResourceService resourceService;

    // Empty constructor
    public ResourceController(ResourceService resourceService){
        this.resourceService = resourceService;
    }

    // @GET
    // Method responsible for getting/show all Users Resources
    @GetMapping
    public List<ResourceDTO> getAllResources(){
        return resourceService.getAllResources();
    }

    // @GET
    // Method responsible for getting a User Resource
    @GetMapping("/{id}")
    public ResourceDTO getResourceById(@PathVariable("id") Long id){
        return resourceService.getResourceById(id);
    }

    //@POST
    // Method responsible for create Users Resource
    @PostMapping
    public void saveResource(@RequestBody ResourceDTO resourceDTO){
        resourceService.saveResource(resourceDTO);
    }

    //@PUT
    // Method responsible for update Users Resource
    @PutMapping
    public ResourceDTO updateResource(@RequestBody ResourceDTO resourceDTO){
        return resourceService.updateResource(resourceDTO);
    }

    //@DELETE
    // Method responsible for DELETE Resource
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable("id") Long id){
        resourceService.deleteResource(id);
        return ResponseEntity.ok().build();
    }


}
