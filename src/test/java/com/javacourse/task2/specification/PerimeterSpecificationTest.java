package com.javacourse.task2.specification;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.repository.impl.PerimeterSpecification;
import com.javacourse.task2.service.impl.TriangleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerimeterSpecificationTest {

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
    void testSpecify() {
        PerimeterSpecification specification = new PerimeterSpecification(18.0, 23.0);
        boolean actual = specification.specify(triangle);
        boolean expected = true;
        assertEquals(expected,actual);
    }
}
