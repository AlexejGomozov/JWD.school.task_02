package com.javacourse.task2.specification;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.repository.impl.AreaSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaSpecificationTest {

    Triangle triangle;
    CustomPoint pointA;
    CustomPoint pointB;
    CustomPoint pointC;

    @BeforeEach
    void prepare() throws TriangleException {
        pointA = new CustomPoint(2.0, 1.0);
        pointB = new CustomPoint(2.0, 6.0);
        pointC = new CustomPoint(8.0, 1.0);
        triangle = new Triangle(pointA, pointB, pointC);
    }

    @Test
    void specifyTest(){
        AreaSpecification areaSpecification = new AreaSpecification(5.0, 13.0);
        boolean expected = false;
        boolean actual = areaSpecification.specify(triangle);
        assertEquals(expected, actual);
    }
}
