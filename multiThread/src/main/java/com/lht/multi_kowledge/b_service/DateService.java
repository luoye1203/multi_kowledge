package com.lht.multi_kowledge.b_service;


import com.lht.multi_kowledge.util.Str2DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;

@Service
public class DateService {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void formatTest(){


        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
        String dateStr=sdf.format(date);
        logger.info(dateStr);
        logger.info(dateStr.length());
        try {
            logger.info(sdf.parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public void formatStandardTest(){

        String[] dateStrArray=new String[]{
                "5612",
                "2014年03月12日 12时05分34秒",
                "2014/03/12 12:05:34",
                "2014-03-12 12:05:34",
                "2014-03-12 12:05",
                "20140312120534157",
                "20140312120534",
                "201403121205",
                "20140312",
        };

         Formatter formatter = new Formatter();

//        Arrays.stream(dateStrArray).peek(dateStr->{
//           logger.info(formatter.format("%-20s ---------------- %-15s",  dateStr, Str2DateFormatUtils.FormatDate(dateStr,"yyyyMMddHHmmssSSS")));
//
//        }).count();


        for (String dateStr:dateStrArray) {
            logger.info(String.format("%-40s---------%-15s",  dateStr, Str2DateFormatUtils.FormatDate(dateStr,"yyyyMMddHHmmssSSS")));
        }




    }

}
