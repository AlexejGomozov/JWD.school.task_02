package com.javacourse.task2.repository.impl;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.repository.Specification;
import com.javacourse.task2.service.impl.TriangleServiceImpl;

public class PerimeterSpecification implements Specification {

    private double fromPerimeter;
    private double toPerimeter;

    public PerimeterSpecification( double fromPerimeter, double toPerimeter){
        this.fromPerimeter = fromPerimeter;
        this.toPerimeter = toPerimeter;
    }
    @Override
    public boolean specify(Triangle triangle){
        TriangleServiceImpl service = new TriangleServiceImpl();
        double perimeter = service.calculatePerimeter(triangle);

        boolean result = perimeter >= fromPerimeter && perimeter <= toPerimeter;
        return result;
    }
}
