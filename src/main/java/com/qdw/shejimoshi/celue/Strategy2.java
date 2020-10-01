package com.qdw.shejimoshi.celue;

import java.util.Arrays;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午6:07
 */
public class Strategy2 implements Strategy {
    private Integer[] arr;

    @Override
    public void setData(Integer[] arr) {
        this.arr = arr;
    }

    @Override
    public void sort() {
        maopao(arr);
    }

    private void maopao(Integer[] arr){
        if (arr.length==0){
            return;
        }
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    @Override
    public void print() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            if (i!=arr.length-1){
                res.append("|");
            }
        }
        System.out.println(res);
    }
}
