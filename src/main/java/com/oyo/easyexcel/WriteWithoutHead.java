package com.oyo.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WriteWithoutHead extends AnalysisEventListener<DemoData> {


    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list，方便内存回收。
     */
    private static final int BATCH_COUNT = 5;
    List<DemoData> list = Lists.newArrayList();


    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(demoData));
        list.add(demoData);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData() {
        log.info("{}条数据，开始存储数据库",list.size());
        log.info("存储数据库成功！");
    }
}
