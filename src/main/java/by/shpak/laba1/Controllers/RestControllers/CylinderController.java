package by.shpak.laba1.Controllers.RestControllers;

import by.shpak.laba1.cache.Cache;
import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.QueryContainer;
import by.shpak.laba1.exceptions.NegativeParameterException;
import by.shpak.laba1.service.CylinderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class CylinderController {
    @Autowired
    CylinderService cylinderService;
    private static final Logger logger = Logger.getLogger(CylinderController.class);

    @GetMapping("/cylinderValue")
    public CylinderDTO CalculateCylinderVolume(@RequestParam(value = "height") double height,
                                               @RequestParam(value = "radius") double radius)
            throws NegativeParameterException {
        if (radius <= 0 || height <= 0) throw new NegativeParameterException();
        QueryContainer queryContainer = new QueryContainer(radius, height);
        if (Cache.getFromCache(queryContainer) != null) {
            return Cache.getFromCache(queryContainer);
        }
        CylinderDTO cylinderDTO = new CylinderDTO(radius, height, cylinderService.calculateVolume(radius, height));
        Cache.putInCache(queryContainer, cylinderDTO);
        logger.info("return GTO");
        return cylinderDTO;
    }
}
