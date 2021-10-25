package com.javacourse.task2.specification;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.repository.impl.IdSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdSpecificationTest {

    Triangle triangle;
    CustomPoint pointA;
    CustomPoint pointB;
    CustomPoint pointC;

    @BeforeEach
    void prepaire() throws TriangleException {
        pointA = new CustomPoint(2.0, 1.0);
        pointB = new CustomPoint(2.0, 6.0);
        pointC = new CustomPoint(8.0, 1.0);
        triangle = new Triangle(pointA, pointB, pointC);
    }
    @Test
    void specifyTest(){
        IdSpecification idSpecification = new IdSpecification(1);
        boolean expected = true;
        boolean actual = idSpecification.specify(triangle);
        assertEquals(expected,actual);
    }
}
