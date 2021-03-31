package by.shpak.laba1.service;

import by.shpak.laba1.Controllers.RestControllers.CylinderController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CylinderService {
    private static final Logger logger = Logger.getLogger(CylinderService.class);
    public double calculateVolume(double radius, double height) {
        logger.info("calculating cylinder's value");
        return 3.14*Math.pow(radius,2)*height;
    }
}
