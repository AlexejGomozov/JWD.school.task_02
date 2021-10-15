package com.javacourse.task2.validation.impl;

import com.javacourse.task2.validation.ValidatorData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorDataImpl implements ValidatorData {
    private final static String REGEX_DIGIT = "-?\\d\\d*(\\.\\d+)?";

    private static ValidatorDataImpl instance;

    public static ValidatorDataImpl getInstance() {
        if (instance == null) instance =  new ValidatorDataImpl();

        return instance;
    }

    @Override
    public boolean validData(String list){
        Pattern pattern = Pattern.compile(REGEX_DIGIT);
        Matcher matcher= pattern.matcher(list);

        return matcher.matches();
    }
}
