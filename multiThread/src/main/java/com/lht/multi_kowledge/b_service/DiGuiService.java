package com.lht.multi_kowledge.b_service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiGuiService {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     **
     * 外部变量相当于全局变量
     * 在递归方法内增删，外部变量也会变化
     *
     *
     *
     * */
    public void diGuiParamTest() {
        List<Integer> outSideList1 = new ArrayList<>();
        List<String> outSideList2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            outSideList2.add("outside2_" + i);
        }
        logger.info(outSideList2);
        this.recurrenceMethod(null, outSideList2, 0);
        logger.info(outSideList2);
    }

    private void recurrenceMethod(List<Integer> outSideList1, List<String> outSideList2, int level) {
        level++;
        outSideList2.remove(0);
        if (level <= 5) {
            this.recurrenceMethod(outSideList1, outSideList2, level);
        }

    }


}
