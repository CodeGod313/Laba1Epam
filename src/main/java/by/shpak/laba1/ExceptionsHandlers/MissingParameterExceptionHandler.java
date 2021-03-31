package by.shpak.laba1.ExceptionsHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissingParameterExceptionHandler {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Missing parameters")
    public void handleMissingParams(MissingServletRequestParameterException ex){
        String name = ex.getParameterName();
        System.out.println(name + " is missing");
    }
}