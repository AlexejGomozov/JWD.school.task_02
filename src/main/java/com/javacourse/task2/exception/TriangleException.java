package com.javacourse.task2.exception;

public class TriangleException extends Exception{
    public TriangleException(){
        super();
    }
    public TriangleException(String message){
        super(message);
    }
    public TriangleException(Exception e){
        super(e);
    }
    public TriangleException(String message, Exception e){
        super(message, e);
    }
}
