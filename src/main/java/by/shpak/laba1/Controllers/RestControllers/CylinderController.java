package by.shpak.laba1.Controllers.RestControllers;

import by.shpak.laba1.domain.CylinderVolume;
import by.shpak.laba1.service.CylinderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CylinderController {
    @Autowired
    CylinderService cylinderService;
    private static final Logger logger = Logger.getLogger(CylinderController.class);
    @GetMapping("/cylinderValue")
    public CylinderVolume CalculateCylinderVolume(@RequestParam(value = "height") double height,
                                                  @RequestParam(value = "radius") double radius){
        logger.info("pizdec");
       // logger.error();
        return new CylinderVolume(height, radius);
    }
}
