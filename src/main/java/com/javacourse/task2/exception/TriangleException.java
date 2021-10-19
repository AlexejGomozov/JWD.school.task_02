package com.javacourse.task2.exception;

public class TriangleException extends Exception{
    public TriangleException(){
        super();
    }
    public TriangleException(String message){
        super(message);
    }
    public TriangleException(Throwable e){
        super(e);
    }
    public TriangleException(String message, Throwable e){
        super(message, e);
    }
}
