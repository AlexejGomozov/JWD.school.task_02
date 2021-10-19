package com.javacourse.task2.repository.impl;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.repository.Specification;

public class IdSpecification implements Specification {
    private long id;

    public IdSpecification(long id){
        this.id = id;
    }
    @Override
    public boolean specify(Triangle triangle){
        boolean result = triangle.getTriangleId()==id;
        return result;
    }
}
