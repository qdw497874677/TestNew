package com.qdw.shejimoshi.celue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午6:07
 */
public class Strategy1 implements Strategy {
    private Integer[] arr;

    @Override
    public void setData(Integer[] arr) {
        this.arr = arr;
    }

    @Override
    public void sort() {
        Arrays.sort(arr);
    }


    @Override
    public void print() {
        List<Integer> list = Arrays.asList(arr);
        List<String> listS = new ArrayList<>();
        list.stream().forEach((a)->{
            listS.add(a.toString());
        });
        String join = String.join(",", listS);
        System.out.println(join);
    }
}
