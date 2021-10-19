package com.javacourse.task2.entity;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Warehouse {
    private static Logger logger= LogManager.getLogger();
    private Map<Long,TriangleParameters> triangleMap;
    private static Warehouse instanse;

    private Warehouse(){
        this.triangleMap = new HashMap<>();
        instanse = new Warehouse();
    }
    public static Warehouse getInstance(){
        return instanse;
    }
    public void putParameters(Long triangleId, TriangleParameters parameters){
        logger.info("Changed parameters in " + triangleId);
        triangleMap.put(triangleId,parameters);
    }
    public void removeParameters(Long triangleId){
        logger.info(triangleId + " - removed");
        triangleMap.remove(triangleId);
    }
    public TriangleParameters getParameters(Long triangleId){
        TriangleParameters parameters = triangleMap.get(triangleId);
        return parameters;
    }
}
