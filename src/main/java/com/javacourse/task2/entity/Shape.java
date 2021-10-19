package com.javacourse.task2.entity;

public abstract class Shape {
    private long shapeID;
    private CustomPoint pointA;

    public Shape() {
        this.pointA = new CustomPoint(0.0, 0.0);
        this.shapeID = 0;
    }
}
