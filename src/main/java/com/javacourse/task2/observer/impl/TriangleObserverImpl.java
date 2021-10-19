package com.javacourse.task2.observer.impl;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.entity.TriangleParameters;
import com.javacourse.task2.entity.Warehouse;
import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.observer.Observer;
import com.javacourse.task2.observer.TriangleEvent;
import com.javacourse.task2.service.TriangleService;
import com.javacourse.task2.service.impl.TriangleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 public class TriangleObserverImpl implements Observer {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public void updatePerimeter(TriangleEvent triangleEvent){
        Triangle triangle = triangleEvent.getSource();
        long id = triangle.getTriangleId();
        Warehouse warehouse = Warehouse.getInstance();
        try{
            TriangleParameters parameters = warehouse.getParameters(id);
            TriangleService service = new TriangleServiceImpl();
            double perimeter = service.calculatePerimeter(triangle);
            parameters.setPerimeter(perimeter);
            logger.info("Perimeter was changed", perimeter);
        }catch(TriangleException e){
    logger.error("Exception occurs while executing the method updatePerimetr", e.getMessage());
        }
    }

    @Override
    public void updateArea(TriangleEvent triangleEvent){
        Triangle triangle = triangleEvent.getSource();
        long id = triangle.getTriangleId();
        Warehouse warehouse = Warehouse.getInstance();
        try{
            TriangleParameters parameters = warehouse.getParameters(id);
            TriangleService service = new TriangleServiceImpl();
            double area = service.calculateArea(triangle);
            parameters.setArea(area);
            logger.info("Area was changed", area);
        }catch (TriangleException e){
            logger.error("Exception occurs while executing the method updateArea", e.getMessage());
        }
    }
}
