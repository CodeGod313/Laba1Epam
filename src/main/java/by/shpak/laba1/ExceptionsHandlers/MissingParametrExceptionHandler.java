package by.shpak.laba1.ExceptionsHandlers;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class MissingParametrExceptionHandler {
    public void handlMissingParams(MissingServletRequestParameterException ex){
        String name = ex.getParameterName();
        System.out.printf(name + "is missing");
    }
}