package by.shpak.laba1.Controllers.RestControllers;

import by.shpak.laba1.domain.CylinderVolume;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@RestController
public class CylinderController {
    private static final Logger logger = Logger.getLogger(CylinderController.class);
    @GetMapping("/cylinderValue")
    public CylinderVolume CalculateCylinderVolume(@RequestParam(value = "height") double height,
                                                  @RequestParam(value = "radius") double radius){
        logger.info("pizdec");
        logger.error();
        return new CylinderVolume(height, radius);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
     @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some parametrs are missing")
     public void handleMissingParams(MissingServletRequestParameterException ex) {
         String name = ex.getParameterName();
         System.out.println(name + " parameter is missing");
    }
}
