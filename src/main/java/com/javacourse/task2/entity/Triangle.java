package com.javacourse.task2.entity;
import com.javacourse.task2.util.IdGenerator;

public class Triangle extends Shape{
    private long triangleId;
    private CustomPoint pointA ;
    private CustomPoint pointB ;
    private CustomPoint pointC ;


    public Triangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC){
        super(pointA, pointB);
        //this.pointA = pointA;
       // this.pointB = pointB;
        this.pointC = pointC;
        this.triangleId = IdGenerator.generate();
    }

    public CustomPoint getPointA() {
        return pointA;
    }
    public CustomPoint getPointB(){
        return pointB;
    }

    public CustomPoint getPointC() {
        return pointC;
    }
}