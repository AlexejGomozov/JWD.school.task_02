package com.javacourse.task2.reader;

import com.javacourse.task2.exception.TriangleException;
import com.javacourse.task2.reader.impl.ReaderFromFileImpl;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReaderTest {

    String[] strExpected = {"1.0 3.0 3...yu5   987", "2.0 1.0   2.0 6.0", "8.0 1.0"};
    String fileName = "resources/testCoordinates";
    ReaderFromFileImpl reader = new ReaderFromFileImpl();

    @Test
    void readerTest()  throws TriangleException {

        List<String> strActual = reader.read(fileName);
        assertArrayEquals( strExpected, strActual.toArray());
    }
}


