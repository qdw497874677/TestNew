package com.qdw.shejimoshi.guanchazhe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午3:00
 */
public class SubjectImpl extends SubjectAbs {
    private String data;
    public Object getData() {
        return data;
    }

    public void execute() {
        DateFormat instance = SimpleDateFormat.getDateTimeInstance();
        data = instance.format(new Date());
    }
}
