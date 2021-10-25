package com.javacourse.task2.warehouse;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.entity.TriangleParameters;
import com.javacourse.task2.entity.Warehouse;
import com.javacourse.task2.exception.TriangleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaehouseTest {

    Triangle triangle;
    CustomPoint pointA;
    CustomPoint pointB;
    CustomPoint pointC;
    Map<Long, TriangleParameters> triangleMap;

    @BeforeEach
    void prepare()  throws TriangleException {
        triangleMap = new HashMap<>();
        pointA = new CustomPoint(2.0, 1.0);
        pointB = new CustomPoint(2.0, 6.0);
        pointC = new CustomPoint(8.0, 1.0);
        triangle = new Triangle(pointA,pointB,pointC);
    }
    @Test
    void addToWarehouseTest(){
       String expected = "{1=TriangleParameters{perimeter = 18.810249675906654, area = 15.0}}";
         Warehouse.getInstance().addToWarehouse(triangle);
        String  actual = Warehouse.getInstance().getTriangles().toString();
        assertEquals( expected, actual);
    }
}