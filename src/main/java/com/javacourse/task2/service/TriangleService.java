package com.javacourse.task2.service;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;

public interface TriangleService {
     double calculatePerimeter(Triangle triangle) throws TriangleException;

     double calculateArea(Triangle triangle) throws TriangleException;

     boolean rightTriangle(Triangle triangle) throws TriangleException;
}
