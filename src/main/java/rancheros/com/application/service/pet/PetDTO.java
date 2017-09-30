package rancheros.com.application.service.pet;

public class PetDTO {

    private String id;
    private String name;
    private String type;

    public PetDTO(){}

    public PetDTO(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
