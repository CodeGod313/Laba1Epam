package by.shpak.laba1.Controllers.rest;

import by.shpak.laba1.cache.Cache;
import by.shpak.laba1.counter.Counter;
import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.CylinderDTOListStat;
import by.shpak.laba1.dto.QueryContainer;
import by.shpak.laba1.exceptions.NegativeParameterException;
import by.shpak.laba1.service.CylinderService;
import by.shpak.laba1.service.CylinderServiceStreamAPI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cylinderValue")
public class CylinderController {
    @Autowired
    CylinderService cylinderService;

    @Autowired
    CylinderServiceStreamAPI cylinderServiceStreamAPI;

    private static final Logger logger = Logger.getLogger(CylinderController.class);

    @GetMapping("/count")
    public CylinderDTO CalculateCylinderVolume(@RequestParam(value = "height") double height,
                                               @RequestParam(value = "radius") double radius)
            throws NegativeParameterException {
        if (radius <= 0 || height <= 0) throw new NegativeParameterException();
        QueryContainer queryContainer = new QueryContainer(radius, height);
        Counter.inc();
        if (Cache.getFromCache(queryContainer) != null) {
            return Cache.getFromCache(queryContainer);
        }
        CylinderDTO cylinderDTO = new CylinderDTO(radius, height, cylinderService.calculateVolume(radius, height));
        Cache.putInCache(queryContainer, cylinderDTO);
        logger.info("return GTO");
        return cylinderDTO;
    }

    @PostMapping("/countViaJSONList")
    public List<CylinderDTO> CalculateCylinderVolumeBulk(@RequestBody  List<QueryContainer> queryContainerList){
        return cylinderServiceStreamAPI.CalculateVolumeList(queryContainerList);
    }

    @PostMapping("/countViaJSONListStat")
    public CylinderDTOListStat CalculateCylinderVolumeBulkStat(@RequestBody List<QueryContainer> queryContainerList){
        return cylinderServiceStreamAPI.CalculateVolumeListStat(queryContainerList);
    }
}
