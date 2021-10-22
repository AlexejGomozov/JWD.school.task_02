package com.javacourse.task2.entity;
import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.observer.Observer;
import com.javacourse.task2.observer.TriangleEvent;

import com.javacourse.task2.observer.impl.TriangleObserverImpl;
import com.javacourse.task2.util.IdGenerator;
import com.javacourse.task2.observer.Observable;
import com.javacourse.task2.validation.impl.ValidatorDataImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Triangle extends Shape implements Observable {
    static final Logger logger = LogManager.getLogger();

    private long triangleId;
    private CustomPoint pointA ;
    private CustomPoint pointB ;
    private CustomPoint pointC ;
    private ArrayList<Observer> observers = new ArrayList<>();

    {
    triangleId = IdGenerator.generate();
    }

    public Triangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC) throws TriangleException {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }
    public long getTriangleId(){
        return triangleId;
    }

    public CustomPoint getPointA() {
        return pointA;
    }
    public void setPointA( CustomPoint pointA){
    this.pointA = pointA;
    notifyObservers();
    }
    public CustomPoint getPointB(){
        return pointB;
    }

    public void setPointB(CustomPoint pointB){
        this.pointB = pointB;
        notifyObservers();
    }

    public CustomPoint getPointC() {
        return pointC;
    }
    public void setPointC(CustomPoint pointC){
        this.pointC = pointC;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer){
      observers.add(observer);
    }
    @Override
    public void detach(Observer observer){
       observers.remove(observer);
    }
    @Override
    public void notifyObservers(){
    if(observers == null){
        logger.info("Observer is null");
        return ;
    }
    TriangleEvent triangleEvent = new TriangleEvent(this);
        if(!observers.isEmpty()){
            for(Observer observ: observers){
                observ.updatePerimeter(triangleEvent);
                observ.updateArea(triangleEvent);
            }
        }
  }
  @Override
    public boolean equals(Object o){
        if(this == o) {return true;}
        if(this == null || this.getClass()!=o.getClass()){return false;}
        Triangle that = (Triangle) o;
        return that.getPointA().equals(getPointA())&&
                that.getPointB().equals(getPointB())&&
                that.getPointC().equals(getPointC());
  }
  @Override
    public int hashCode(){
        int result = 1;
        result = result*31 + ((pointA==null)? 0 :pointA.hashCode());
        result = result*31 + ((pointB==null)? 0 :pointB.hashCode());
        result = result*31 + ((pointC==null)? 0 :pointC.hashCode());
        return result;
  }
  @Override
    public String toString(){
        final StringBuilder triangleString = new StringBuilder("Triangle{");
        triangleString.append("triangleId = ").append(triangleId);
        triangleString.append(", pointA = ").append(pointA);
        triangleString.append(", pointB = ").append(pointB);
        triangleString.append(", pointC = ").append(pointC);
        triangleString.append("}");
        return triangleString.toString();
  }
}