package by.shpak.laba1.service;

import by.shpak.laba1.cache.Cache;
import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.QueryContainer;
import by.shpak.laba1.dto.VolumeDTO;
import by.shpak.laba1.repos.VolumeDTORepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CylinderServiceAsync {

    private static Logger logger = Logger.getLogger(CylinderServiceAsync.class);
    @Autowired
    private CylinderService cylinderService;

    @Autowired
    private VolumeDTORepository volumeDTORepository;

    public void calculateAsync(Long id, QueryContainer queryContainer){
        logger.info("Starting new thread");
        CompletableFuture.supplyAsync(()->cylinderService.calculateVolume(queryContainer))
                .thenApply(x->volumeDTORepository.save(new VolumeDTO(id,x.getVolume())));
    }
}
