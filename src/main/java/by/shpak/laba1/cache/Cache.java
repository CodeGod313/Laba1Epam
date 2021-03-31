package by.shpak.laba1.cache;

import by.shpak.laba1.dto.CylinderDTO;
import by.shpak.laba1.dto.QueryContainer;
import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<QueryContainer, CylinderDTO> cache = new HashMap<>();
    private static Logger logger = Logger.getLogger(Cache.class);
    public static CylinderDTO getFromCache(QueryContainer key){
        logger.info("getting value from cache");
        return cache.get(key);
    }

    public static void putInCache(QueryContainer key, CylinderDTO value){
        logger.info("putting calculated value in cache");
        cache.put(key,value);
    }
}
