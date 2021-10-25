package com.javacourse.task2.comparator;

import com.javacourse.task2.entity.Triangle;
import java.util.Comparator;

import com.javacourse.task2.service.impl.TriangleServiceImpl;

public class TriangleCompareArea implements Comparator<Triangle> {
    @Override
            public int compare(Triangle o1, Triangle o2)  {
        TriangleServiceImpl service = new TriangleServiceImpl();
        int result = 0;
            double area1 = service.calculateArea(o1);
            double area2 = service.calculateArea(o2);

        if(area1 - area2 < 0) {result = -1;}
        else if(area1 - area2 > 0) {result = 1;}

        return result;
    }
}
