package com.javacourse.task2.validation.impl;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.service.impl.TriangleServiceImpl;
import com.javacourse.task2.validation.ValidatorData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorDataImpl implements ValidatorData {
    private final static String REGEX_DIGIT = "-?\\d\\d*(\\.\\d+)?";

    private static ValidatorDataImpl instance =  new ValidatorDataImpl();

    public static ValidatorDataImpl getInstance() {
        return instance;
    }
    TriangleServiceImpl triangleServiceImpl = new TriangleServiceImpl();
    @Override
    public boolean validData(String list){
        Pattern pattern = Pattern.compile(REGEX_DIGIT);
        Matcher matcher= pattern.matcher(list);

        return matcher.matches();
    }
    @Override
    public boolean validTriangle(Triangle triangle){
        double [] sides = triangleServiceImpl.calculateTriangleSide(triangle);
        return sides[0]+sides[1]>sides[2]&&
                sides[1]+sides[2]>sides[0]&&
                sides[0]+sides[2]>sides[1];
    }
}
