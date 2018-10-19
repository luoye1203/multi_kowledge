package com.lht.multi_kowledge.b_service;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
