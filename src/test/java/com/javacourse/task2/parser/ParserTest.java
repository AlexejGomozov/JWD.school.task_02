package com.javacourse.task2.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.javacourse.task2.parser.impl.ParserDataImpl;

import java.util.Arrays;
import java.util.List;

public class ParserTest {

    List<String> actualStr = Arrays.asList("1  3", "2  6", "2 3 4 sofas 2", "3 3 4 ", "2   7");
    List<Double> expected = Arrays.asList(1.0, 3.0, 2.0, 6.0, 3.0, 3.0, 4.0, 2.0, 7.0);

    @Test
    void parseDataList(){
        ParserDataImpl parser = new ParserDataImpl();
        List<Double> actual = parser.parseDataList(actualStr);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
