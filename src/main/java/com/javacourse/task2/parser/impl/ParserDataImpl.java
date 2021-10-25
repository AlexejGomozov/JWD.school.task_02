package com.javacourse.task2.parser.impl;

import com.javacourse.task2.parser.ParserData;
import com.javacourse.task2.validation.impl.ValidatorDataImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserDataImpl implements ParserData {
    static final Logger logger = LogManager.getLogger();
    private static final String REGEX_SPLIT = "\s";

    @Override
   public List<Double> parseDataList(List<String> list1) {
        List<Double> listAfterParse = new ArrayList<>();

        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {

          String line = iterator.next();
            String[] lineAfterSplit = line.split(REGEX_SPLIT);

            int i=0;
            List<Double> listCoordLokal = new ArrayList<>(); //пропускаем всю строку. т.е валидные значения этой строки не добавляются
            while (i<lineAfterSplit.length) {               //в List, а переходим к след строке

                String strForValid = lineAfterSplit[i];
                if(strForValid.equals("")){i++; continue;}

                  if (ValidatorDataImpl.getInstance().validData(strForValid)) {
                      double value = Double.parseDouble(strForValid);
                      listCoordLokal.add(value);
                  }else break;                                        //переходим к др строке
               if(i == lineAfterSplit.length-1) {listAfterParse.addAll(listCoordLokal);}
               i++;
           }
        }
        logger.info( "List<Double> after parse " +  listAfterParse);
        return listAfterParse;
    }
}