package com.lht.multi_kowledge.b_service;

import com.lht.multi_kowledge.thread.ReturnResultLongThread;
import com.lht.multi_kowledge.thread.ReturnResultThread;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

@Service
public class ThreadTestService {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void jionMethodTest() {
        logger.info("线程测试开始");
        FutureTask<Set<String>> futureTask = new FutureTask<Set<String>>(new ReturnResultThread());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            thread.join(10000);

            logger.info("附加线程结束");
            Set<String> set = futureTask.get();
            logger.info(set);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void jionMethodTest2() {
        logger.info("线程测试开始");
        FutureTask<Set<String>> futureTask = new FutureTask<Set<String>>(new ReturnResultThread());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            thread.join(10000);
            if (futureTask.isDone()) {
                Set<String> set = futureTask.get();
                logger.info(set);
            } else {
                thread.stop();
                logger.info("附加线程被强制结束");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void threadPoolTest() {
        //对比多线程 查看执行效率
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);

        //对比单线程 查看执行效率
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);


        List<Future<Set<String>>> futuresResultList = new ArrayList<>();

        Long startTime = System.currentTimeMillis();

        for (int i = 0; i < 8; i++) {
            Future<Set<String>> futureResult = fixedThreadPool.submit(new ReturnResultThread());
            futuresResultList.add(futureResult);
        }

        for (int i = 0; i < futuresResultList.size(); i++) {
            try {
                Set<String> set = futuresResultList.get(i).get();
                logger.info(set);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        fixedThreadPool.shutdown();

        Long endTime = System.currentTimeMillis();

        Long usedTime = (endTime - startTime) / 1000;

        logger.info("用时" + usedTime + "秒");
    }


    public void threadPoolWaitTest() {

        //对比单线程 查看执行效率
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);


        List<Future<Set<String>>> futuresResultList = new ArrayList<>();

        Long startTime = System.currentTimeMillis();

        //线程运行时间短
        Future<Set<String>> futureResultShort = fixedThreadPool.submit(new ReturnResultThread());
//        futuresResultList.add(futureResultShort);

        //线程运行时间长
        Future<Set<String>> futureResultLong = fixedThreadPool.submit(new ReturnResultLongThread());
//        futuresResultList.add(futureResultLong);


        try {
            Set<String> set2 = futureResultLong.get(10, TimeUnit.SECONDS);
            logger.info("截取获取:" + set2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Set<String> set1 = null;
        try {
            set1 = futureResultShort.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        logger.info("自然获取:" + set1);
        fixedThreadPool.shutdownNow();

        Long endTime = System.currentTimeMillis();

        Long usedTime = (endTime - startTime) / 1000;

        logger.info("用时" + usedTime + "秒");
    }


}
