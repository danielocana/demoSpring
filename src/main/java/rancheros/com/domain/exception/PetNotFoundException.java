package rancheros.com.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This pet is not found in the system")
public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(String id) {
        super("Pet with Id: " + id + " not found");
    }

    public String getCode() {
        return "404";
    }
}
