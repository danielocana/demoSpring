package rancheros.com.spring.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rancheros.com.application.service.pet.*;
import rancheros.com.domain.pet.Pet;
import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private FindAllPetsUseCase findAllPetsUseCase;

    private FindByIdPetUseCase findByIdPetUseCase;

    private CreatePetUseCase createPetUseCase;

    private UpdatePetUseCase updatePetUseCase;

    private DeletePetUseCase deletePet;

    @Inject
    public PetController(FindAllPetsUseCase findAllPetsUseCase,
                         FindByIdPetUseCase findByIdPetUseCase,
                         CreatePetUseCase createPetUseCase,
                         UpdatePetUseCase updatePetUseCase,
                         DeletePetUseCase deletePet) {
        this.findAllPetsUseCase = findAllPetsUseCase;
        this.findByIdPetUseCase = findByIdPetUseCase;
        this.createPetUseCase = createPetUseCase;
        this.updatePetUseCase = updatePetUseCase;
        this.deletePet = deletePet;
    }

    @ApiOperation(value = "Listar todas las mascotas")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Pet.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Pet> findAllPets (@RequestParam( defaultValue = "0", required=false, name = "offset") String offset,
                                  @RequestParam( defaultValue = "20", required=false, name = "limit") String limit){
        return findAllPetsUseCase.findAll(offset,limit).toList().toBlocking().first();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public PetDTO findById (@PathVariable String id){
        return findByIdPetUseCase.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pet create (@RequestBody Pet pet) {
        return createPetUseCase.insert(pet);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Pet update (@RequestBody Pet pet, @PathVariable String id) {
        pet.setId(id);
        return updatePetUseCase.update(pet);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        deletePet.delete(id);
    }

    //TODO exceptions
}
