package com.javacourse.task2.service.impl;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class TriangleServiceImpl implements TriangleService {
    static final Logger logger = LogManager.getLogger();

@Override
public double calculatePerimeter(Triangle triangle){
       double[] sides = calculateTriangleSide(triangle);
       double perimeter = 0;
       for(double s: sides){perimeter +=s;}
    logger.info("Perimeter of " + triangle.getTriangleId() + " is: " + perimeter);
    return perimeter;
}
@Override
public double calculateArea(Triangle triangle)  {
    double halfPerimeter = calculatePerimeter(triangle)/2;
    double areaByHeronFormula =
            Math.sqrt(halfPerimeter*(halfPerimeter - calculateTriangleSide(triangle)[0])*
            (halfPerimeter - calculateTriangleSide(triangle)[1])*
            (halfPerimeter - calculateTriangleSide(triangle)[2]));
    logger.info("Area of " + triangle.getTriangleId() + " is: " + areaByHeronFormula);
    return areaByHeronFormula;
}
@Override
public boolean rightTriangle(Triangle triangle){
          double [] sides = calculateTriangleSide(triangle);
          Arrays.sort(sides);
          boolean rightTriangleByPythagor = Math.pow(sides[0],2) + Math.pow(sides[1],2)==Math.pow(sides[2],2);
    logger.info(rightTriangleByPythagor ?"Triangle " +
           triangle + " is right." : "Triangle " + triangle.getTriangleId()+ "isn't right");
    return rightTriangleByPythagor;
}

    public double calculateSide(CustomPoint pointA, CustomPoint pointB) {
        return  Math.sqrt(Math.pow(pointB.getPointAxisX() - pointA.getPointAxisX(), 2) +
                Math.pow(pointB.getPointAxisY() - pointA.getPointAxisY(), 2));
    }

    public double[] calculateTriangleSide(Triangle triangle) {
        double sideAB = calculateSide(triangle.getPointA(), triangle.getPointB());
        double sideBC = calculateSide(triangle.getPointB(), triangle.getPointC());
        double sideAC = calculateSide(triangle.getPointA(), triangle.getPointC());

        return new double[]{sideAB, sideBC, sideAC};
    }
}