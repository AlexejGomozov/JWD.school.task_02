package com.javacourse.task2.main;

import com.javacourse.task2.entity.Triangle;
import com.javacourse.task2.exception.TriangleException;

import com.javacourse.task2.factory.TriangleFactory;
import com.javacourse.task2.parser.impl.ParserDataImpl;
import com.javacourse.task2.reader.impl.ReaderFromFileImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws TriangleException {

        ReaderFromFileImpl reader = new ReaderFromFileImpl();
        ParserDataImpl parser = new ParserDataImpl();

        List<String> text = reader.read("resources/coordinates");
        List<Double> listDouble = parser.parseDataList(text);

        Triangle triangle = TriangleFactory.getInstance().createTriangle(listDouble);
        logger.info( triangle);
    }
}
