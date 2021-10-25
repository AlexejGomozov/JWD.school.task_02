package com.javacourse.task2.factory;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TriangleFactory {
    static final Logger logger = LogManager.getLogger();
    private static final int AMOUNT_POINT = 6;
    private static TriangleFactory instance;

    private TriangleFactory() {
        instance = new TriangleFactory();
    }

    public static TriangleFactory getInstance() {
        return instance;
    }

    public static List<Triangle> createTriangle(List<Double> coordinates) throws TriangleException {

        List<Triangle> listTriangle = new ArrayList<>();

        List<List<Double>> listCoordTriangle = new ArrayList<>();
        Iterator iterator = coordinates.iterator();

         int counter = 0;
         while (iterator.hasNext()) {
               List<Double> listCoordLokal = new ArrayList<>();

           while (true){
                   Double value = (Double) iterator.next();
               listCoordLokal.add(value);

                   if (listCoordLokal.size() == AMOUNT_POINT) {
                       listCoordTriangle.add(listCoordLokal);
                       break;
                   }
                   counter++;
           }
    }
        if (coordinates.size() < AMOUNT_POINT) {
            logger.error("Not enough data");
            throw new TriangleException("Not enough data");
        }
        for(List<Double> n :listCoordTriangle) {
            CustomPoint firstPoint = new CustomPoint(n.get(0), n.get(1));
            CustomPoint secondPoint = new CustomPoint(n.get(2), n.get(3));
            CustomPoint thirdPoint = new CustomPoint(n.get(4), n.get(5));

            Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
            listTriangle.add(triangle);
        }
   return listTriangle;
    }
}


