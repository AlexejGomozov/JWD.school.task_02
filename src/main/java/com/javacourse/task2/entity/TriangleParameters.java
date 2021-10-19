package com.javacourse.task2.entity;

public class TriangleParameters {
    private double perimeter;
    private double area;

    public TriangleParameters(double perimeter, double area){
        this.perimeter = perimeter;
        this.area = area;
    }
    public double getPerimeter(){
        return perimeter;
    }
    public void setPerimeter(double perimeter){
        this.perimeter = perimeter;
    }

    public double getArea(){
        return area;
    }
    public void setArea(double area){
        this.area = area;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(this == null || this.getClass()!=o.getClass()) return false;
        TriangleParameters that = (TriangleParameters) o;
        return Double.compare(that.perimeter,((TriangleParameters) o).perimeter)==0 &&
                Double.compare(that.area,((TriangleParameters) o).area)==0;
    }
    public int hashcode(){
        int result = 1;
        result = result*31 + (int)perimeter;
        result = result*31 + (int)area;
        return result;
    }
    @Override
    public String toString() {
        final StringBuilder triangleParameters = new StringBuilder("TriangleParameters{");
        triangleParameters.append("perimeter = ").append(perimeter);
        triangleParameters.append(", area = ").append(area);
        triangleParameters.append("}");
        return triangleParameters.toString();
    }
}

