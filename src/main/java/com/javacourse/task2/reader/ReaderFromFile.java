package com.javacourse.task2.reader;
import com.javacourse.task2.exception.TriangleException;

import java.util.List;

public interface ReaderFromFile {
    List<String> read(String fileName) throws TriangleException;
}
//String