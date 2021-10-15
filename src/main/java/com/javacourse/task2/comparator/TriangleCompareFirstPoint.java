package com.javacourse.task2.comparator;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.entity.CustomPoint;
import java.util.Comparator;

public class TriangleCompareFirstPoint implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2){
        int result = 0;
        Double firstPoint1 = o1.getPointA().getPointAxisX();
        Double firstPoint2 = o2.getPointA().getPointAxisX();
        if(firstPoint1 - firstPoint2 < 0){
            result = -1;
        }else if(firstPoint1 - firstPoint2 > 0){
            result = 1;}
        return result;
    }

}
