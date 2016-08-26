package rancheros.com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rancheros.com.domain.ErrorMessage;
import rancheros.com.domain.exception.PersonNotFoundException;
import rx.exceptions.OnErrorNotImplementedException;

@ControllerAdvice(annotations  = RestController.class)
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage handlePersonNotFoundException(PersonNotFoundException exception) {
        return new ErrorMessage(exception.getCode(), exception.getMessage(), exception.getLocalizedMessage());
    }

    @ExceptionHandler(value = OnErrorNotImplementedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage handleErrorNotImplemented(OnErrorNotImplementedException exception) {
        return new ErrorMessage("500", exception.getMessage(), exception.getLocalizedMessage());
    }
}
