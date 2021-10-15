package com.javacourse.task2.entity;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class Warehouse {
    private static Logger logger= LogManager.getLogger();
    private Map<Long,TriangleParameters> triangleMap;
    private Warehouse instanse;

    private Warehouse(){
        this.triangleMap = new HashMap<>();
    }
    public Warehouse getInstanse(){
        instanse = new Warehouse();
        return instanse;
    }
    public void putParameters(Long triangleId, TriangleParameters parameters){
        logger.info("Changed parameters in " + triangleId);
        triangleMap.put(triangleId,parameters);
    }
    public void removeParameters(Long triangleId){
        logger.info(triangleId + " - removed");
        triangleMap.remove(triangleId);   // если удалить ключ, то удалится и значение?
    }
    public TriangleParameters getParameters(Long triangleId){
        TriangleParameters parameters = triangleMap.get(triangleId);
        return parameters;
    }
}
//hashcode
//equals
//toString