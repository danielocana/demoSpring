package rancheros.com.spring.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import rancheros.com.application.service.pet.CreatePet;
import rancheros.com.application.service.pet.FindAllPets;
import rancheros.com.application.service.pet.FindByIdPet;
import rancheros.com.domain.pet.Pet;
import javax.inject.Inject;
import java.util.List;


@RestController
@RequestMapping("/pets")
public class PetController {

    private FindAllPets findAllPets;

    private FindByIdPet findByIdPet;

    private CreatePet createPet;

    @Inject
    public PetController(FindAllPets findAllPets,
                         FindByIdPet findByIdPet,
                         CreatePet createPet) {
        this.findAllPets = findAllPets;
        this.findByIdPet = findByIdPet;
        this.createPet = createPet;
    }

    @ApiOperation(value = "Listar todas las mascotas")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Pet.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Pet> findAllPets (){
        return findAllPets.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Pet findById (@PathVariable String id){
        return findByIdPet.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pet create (@RequestBody Pet pet) {
        return createPet.insert(pet);
    }
}
