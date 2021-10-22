package com.javacourse.task2.main;

import com.javacourse.task2.entity.CustomPoint;
import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.entity.TriangleParameters;
import com.javacourse.task2.entity.Warehouse;
import com.javacourse.task2.exception.TriangleException;

import com.javacourse.task2.factory.TriangleFactory;
import com.javacourse.task2.observer.Observable;
import com.javacourse.task2.observer.Observer;
import com.javacourse.task2.observer.impl.TriangleObserverImpl;
import com.javacourse.task2.parser.impl.ParserDataImpl;
import com.javacourse.task2.reader.impl.ReaderFromFileImpl;
import com.javacourse.task2.repository.Repository;
import com.javacourse.task2.repository.impl.PerimeterSpecification;
import com.javacourse.task2.validation.impl.ValidatorDataImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws TriangleException {

        ReaderFromFileImpl reader = new ReaderFromFileImpl();
        ParserDataImpl parser = new ParserDataImpl();

        List<String> text = reader.read("resources/coordinates");
        List<Double> listDouble = parser.parseDataList(text);

        List<Triangle> triangles = TriangleFactory.getInstance().createTriangle(listDouble);
        logger.info( triangles);

        Repository repository = Repository.getInstance();
        Warehouse warehouse = Warehouse.getInstance();

        Observer observer = new TriangleObserverImpl();

        for(Triangle triangle : triangles) {
            if (ValidatorDataImpl.getInstance().validTriangle(triangle)) {
           triangle.attach(observer);
                repository.addToRep(triangle);
                warehouse.addToWarehouse(triangle);
            }
        }
        PerimeterSpecification perimeterSpecification = new PerimeterSpecification(12.0,16.0);
    List<Triangle> trianglesAfterSpecification = repository.query(perimeterSpecification);
    logger.info("Triangles after Perimeter's specification: " + trianglesAfterSpecification);

        Triangle selectedTriangleFromRep= repository.getTriangleByIndex(0);
        TriangleParameters selectedTriangleParamFromWareh = warehouse.getParameters(selectedTriangleFromRep.getTriangleId());
        logger.info("Selected Triangle by index from repository: " + selectedTriangleFromRep);
        logger.info("Selected Parameters of Triangle by ID from warehouse: "+ selectedTriangleParamFromWareh);


        selectedTriangleFromRep.setPointA(new CustomPoint(2.0,4.0));

       // logger.info("PointA of triangle " + selectedTriangleFromRep.getTriangleId() + " was changed.");
//       TriangleParameters selectedTriangleParamFromWarehAfterChange = warehouse.getParameters(selectedTriangleFromRep.getTriangleId());
//    logger.info("Selected Parameters of Triangle by ID from warehouse after change: " +
//            selectedTriangleParamFromWarehAfterChange);
    }
}
