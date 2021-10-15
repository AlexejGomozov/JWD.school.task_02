package com.javacourse.task2.entity;

public class CustomPoint {
    private double pointAxisX;
    private double pointAxisY;


    public CustomPoint(double pointAxisX, double pointAxisY) {
        this.pointAxisX = pointAxisX;
        this.pointAxisY = pointAxisY;


    }

    public double getPointAxisX() {
        return pointAxisX;
    }

    public void setPointA(double pointA) {
        this.pointAxisX = pointAxisX;
    }

    public double getPointAxisY() {
        return pointAxisY;
    }

    public void setPointAxisY(double pointAxisY) {
        this.pointAxisY = pointAxisY;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CustomPoint customPoint = (CustomPoint) o;
        return Double.compare(customPoint.pointAxisX, pointAxisX)==0 &&
                Double.compare(customPoint.pointAxisY, pointAxisY)==0;
                 }
    @Override
    public int hashCode(){
        int result = 1;
        result =result*31 + (int) pointAxisX;//переделать. вместо double д.б. int
        result =result*31 + (int) pointAxisY;
        return result;
    }

    @Override
    public String toString() {  //через  StringBuffer
        return "CastomPoint{" +
                "pointA=" + pointAxisX +
                ", pointB=" + pointAxisY +
                '}';
    }
}