package com.javacourse.task2.util;

public class IdGenerator {
    private static long counter;
    private IdGenerator(){
    }
    public  static long generate(){
        return ++counter;
    }
}
