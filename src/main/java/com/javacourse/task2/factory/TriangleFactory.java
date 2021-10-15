package com.javacourse.task2.factory;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class TriangleFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final int AMOUNT_POINT = 6;

    private TriangleFactory() {
    }

public static Triangle createTriangle(List<Double> coordinates) throws TriangleException {

        if(coordinates.size()!=AMOUNT_POINT){
            logger.error("Not enough data");
            throw new TriangleException("Not enough data");
        }
    CustomPoint firstPoint = new CustomPoint(coordinates.get(0),coordinates.get(1));
    CustomPoint secondPoint = new CustomPoint(coordinates.get(2),coordinates.get(3));
    CustomPoint thirdPoint = new CustomPoint(coordinates.get(4),coordinates.get(5));
    Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
    logger.info("Triangle is ready");

    return triangle;
}
}