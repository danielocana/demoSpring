package rancheros.com.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This person is not found in the system")
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String id) {
        super("Person with Id: " + id + " not found");
    }

    public String getCode() {
        return "404";
    }
}
