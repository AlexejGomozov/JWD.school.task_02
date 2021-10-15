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
    //private static final String REGEX_SPACE = "\s";
    @Override
    public List<String> read(String fileName) throws TriangleException {
        //public List<String> public String
        //StringBuilder strBuilder = new StringBuilder();
        //вместо одной строки создаем лист строк, чтобы эту строку либо провалидировать
        List<String> strList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new FileReader(fileName))){
            //while(scanner.hasNext()) {
                 while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
               // strBuilder.append(line + REGEX_SPACE);
                     if(line != null)  {strList.add(line);}

            }
        } catch (FileNotFoundException e){
            logger.log(Level.ERROR, "File" + fileName + " was not found", e);
            throw  new TriangleException("File was not found", e);
        }
        //return strBuilder.toString();
        return strList;
    }
}
