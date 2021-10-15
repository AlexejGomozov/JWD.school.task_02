package com.javacourse.task2.reader.impl;

import com.javacourse.task2.reader.ReaderFromFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.javacourse.task2.exception.TriangleException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderFromFileImpl implements ReaderFromFile {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<String> read(String fileName) throws TriangleException {

        List<String> strList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new FileReader(fileName))){

                 while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                     if(line != null)  {strList.add(line);}
            }
        } catch (FileNotFoundException e){
            logger.log(Level.ERROR, "File" + fileName + " was not found", e);
            throw  new TriangleException("File was not found", e);
        }
        return strList;
    }
}
