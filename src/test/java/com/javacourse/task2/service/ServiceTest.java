package com.javacourse.task2.service;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.factory.TriangleFactory;
import com.javacourse.task2.service.impl.TriangleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class ServiceTest {

    Triangle triangle;
    TriangleServiceImpl service;
    CustomPoint pointA;
    CustomPoint pointB;
    CustomPoint pointC;

    @BeforeEach
    void prepare() throws TriangleException {
        pointA = new CustomPoint(2.0,1.0);
        pointB = new CustomPoint(2.0,6.0);
        pointC = new CustomPoint(8.0,1.0);
        service = new TriangleServiceImpl();
        triangle = new Triangle( pointA,pointB,pointC);

}
    @Test
      void testCalculatePerimeter(){
                double expected = 18.810249675906654;
                double actual = service.calculatePerimeter(triangle);
                assertEquals(expected, actual);
    }
    @Test
    void testCalculateSide(){
        double expected = 4.0;
        double actual = service.calculateSide(pointA,pointB);
        assertEquals(expected,actual);
    }
    @Test
    void testCalculateArea(){
        double expected = 15.0;
        double actual = service.calculateArea(triangle);
        assertEquals(expected,actual);
    }
    @Test
    void testRightTriangle(){
        boolean expected = false;
        boolean actual = service.rightTriangle(triangle);
        assertEquals(expected,actual);
    }
    @Test
    void testCalculateTriangleSide(){
        double[] expected = {5.0,7.810249675906654,6.0};
        double[] actual = service.calculateTriangleSide(triangle);
        assertArrayEquals(expected, actual);
    }
}
