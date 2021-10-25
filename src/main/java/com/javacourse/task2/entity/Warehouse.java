package com.javacourse.task2.entity;

import java.util.HashMap;
import java.util.Map;

import com.javacourse.task2.service.impl.TriangleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Warehouse {
    static Logger logger= LogManager.getLogger();
    private static Warehouse instance;
    private Map<Long,TriangleParameters> triangleMap;

    private Warehouse(){
        this.triangleMap = new HashMap<>();
    }
    public static Warehouse getInstance(){
        if (instance == null) instance = new Warehouse();
        return instance;
    }
    public void putParameters(Long triangleId, TriangleParameters value){
        logger.info("Put parameters " + value + " in " + triangleId + " triangle");
        triangleMap.put(triangleId,value);
    }
    public void removeParameters(Long triangleId){
        logger.info(triangleId + " - removed");
        triangleMap.remove(triangleId);
    }
    public TriangleParameters getParameters(Long triangleId){
        return triangleMap.get(triangleId);
    }
    public Map<Long, TriangleParameters> getTriangles(){
        return Map.copyOf(triangleMap);
    }

    public void addToWarehouse(Triangle triangle){

        TriangleServiceImpl service = new TriangleServiceImpl();

            double perimeter = service.calculatePerimeter(triangle);
            double area = service.calculateArea(triangle);
        TriangleParameters  parameters = new TriangleParameters(perimeter, area);
            putParameters(triangle.getTriangleId(),parameters);
        }
}
