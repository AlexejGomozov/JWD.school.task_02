package com.javacourse.task2.entity;

public abstract class Shape {
    long shapeID;
    Object pointA;
    Object pointB;


    public Shape(Object pointA, Object pointB){
        this.pointA = pointA;
        this.pointB = pointB;
        this.shapeID = shapeID;
    }

}
