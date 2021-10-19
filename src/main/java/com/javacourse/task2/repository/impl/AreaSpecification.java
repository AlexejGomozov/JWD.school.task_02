package com.javacourse.task2.repository.impl;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.repository.Specification;
import com.javacourse.task2.service.impl.TriangleServiceImpl;

public class AreaSpecification implements Specification {

    double minArea;
    double maxArea;

    public AreaSpecification(double minArea, double maxArea){
        this.minArea = minArea;
        this.maxArea = maxArea;
    }
    @Override
    public boolean specify(Triangle triangle){
       TriangleServiceImpl service = new TriangleServiceImpl();
       double area = service.calculateArea(triangle);
       boolean result = area>= minArea && area <= maxArea;
       return result;
    }

}
