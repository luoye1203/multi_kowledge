package com.lht.multi_kowledge.thread;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;


public class ReturnResultLongThread implements Callable<Set<String>> {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Set<String> call() throws Exception {
        Set<String> reData=new HashSet<>();

        for (int i = 0; i <10 ; i++) {
            int randomNum=(int)( Math.random()*10);
            logger.info("非自然"+randomNum);
            reData.add(randomNum+"");
            Thread.sleep(5000);
        }








        return reData;
    }
}
