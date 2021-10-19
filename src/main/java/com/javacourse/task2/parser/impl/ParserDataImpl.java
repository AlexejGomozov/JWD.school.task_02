package com.javacourse.task2.parser.impl;

import com.javacourse.task2.parser.ParserData;
import com.javacourse.task2.validation.impl.ValidatorDataImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ParserDataImpl implements ParserData {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEX_SPLIT = "\s";

    @Override
   public List<Double> parseDataList(List<String> list1) {
        List<Double> list3 = new ArrayList<>();

        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {

          String line = iterator.next();
            String[] lineAfterSplit = line.split(REGEX_SPLIT);
            logger.info( "String[] lineAfterSplit" + Arrays.toString(lineAfterSplit));

            int i=0;                    // в этом while парсим строку, если в строке хоть одно значение невалидно, то
            List<Double> list2 = new ArrayList<>(); //пропускаем всю строку. т.е валидные значения этой строки не добавляются
            while (i<lineAfterSplit.length) {      //в List, а переходим к след строке

                String strForValid = lineAfterSplit[i];
                if(strForValid.equals("")){i++; continue;}

                  if (ValidatorDataImpl.getInstance().validData(strForValid)) {
                      double value = Double.parseDouble(strForValid);
                      list2.add(value);
                      logger.info( "List<Double> list2 " +  list2);
                  }else break;                                        //переходим к др строке
               if(i == lineAfterSplit.length-1) {list3.addAll(list2);}
               i++;
           }
        }
        logger.info( "List<Double> list3 " +  list3);
        return list3;
    }
}