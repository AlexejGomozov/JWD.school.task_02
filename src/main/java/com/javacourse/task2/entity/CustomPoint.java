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

    public void setPointAxisX(double pointAxisX) {
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
        return Double.compare(customPoint.pointAxisX, pointAxisX) == 0 &&
                Double.compare(customPoint.pointAxisY, pointAxisY) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (int)((pointAxisX == 0) ? 0 : pointAxisX);
        result = result * 31 + (int)((pointAxisY == 0) ? 0 : pointAxisY);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder pointString = new StringBuilder("{");
        pointString.append("pointAxisX = ").append(pointAxisX);
        pointString.append(", pointAxisY = ").append(pointAxisY);
        pointString.append("}");
        return pointString.toString();
    }
}