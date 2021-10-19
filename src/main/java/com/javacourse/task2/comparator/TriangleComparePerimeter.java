package com.javacourse.task2.comparator;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.service.impl.TriangleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TriangleComparePerimeter implements Comparator<Triangle> {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public int compare(Triangle o1, Triangle o2){
    int result = 0;
        TriangleServiceImpl service = new TriangleServiceImpl();

        double perimetr1 =  service.calculatePerimeter(o1);
        double perimetr2 = service.calculatePerimeter(o2);
       if(perimetr1 - perimetr2 < 0) {result = -1;}
       else if(perimetr1 - perimetr2 > 0) {result = 1;}

      return result;
    }
}
