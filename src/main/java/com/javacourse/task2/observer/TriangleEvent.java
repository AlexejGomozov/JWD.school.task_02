package com.javacourse.task2.observer;

import com.javacourse.task2.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {
    /**
     *  Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    public TriangleEvent(Triangle source){
        super(source);
    }
    @Override
    public Triangle getSource(){
        return (Triangle) super.getSource();
    }
}
