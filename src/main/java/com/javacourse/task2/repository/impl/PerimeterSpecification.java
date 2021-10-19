package com.javacourse.task2.repository.impl;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.repository.Specification;
import com.javacourse.task2.service.impl.TriangleServiceImpl;

public class PerimeterSpecification implements Specification {

    private double minPerimeter;
    private double maxPerimeter;

    public PerimeterSpecification( double minPerimeter, double maxPerimeter){
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }
    @Override
    public boolean specify(Triangle triangle){
        TriangleServiceImpl service = new TriangleServiceImpl();
        double perimeter = service.calculatePerimeter(triangle);

        boolean result = perimeter >= minPerimeter && perimeter <= maxPerimeter;
        return result;
    }
}
