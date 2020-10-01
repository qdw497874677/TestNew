package com.qdw.paixu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @PackageName:com.qdw.paixu
 * @ClassName: youdianduilie
 * @Description:
 * @date: 2020/9/26 0026 21:48
 */
public class Youdianduilie<T> {

    public static void main(String[] args) {
        Youdianduilie<Integer> youdianduilie = new Youdianduilie<>();
        youdianduilie.add(3);
        youdianduilie.add(2);
        youdianduilie.add(4);
        youdianduilie.add(1);
        System.out.println(youdianduilie.peek());
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
//        youdianduilie.swap(list,1,2);
//        youdianduilie.buildHeap(list);
//        System.out.println(list);
    }
    Comparator comparator;
    List<Integer> list;
    public Youdianduilie(){
        comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
        list = new ArrayList<>();
    }

    public void add(int value){
        list.add(value);
        adjustToTop(list,list.size()-1);
    }
    public Integer peek(){
        return list.size()==0?-1:list.get(0);
    }

    public void buildHeap(List<Integer> list){
        for (int i = list.size()/2-1; i >=0; i--) {
            adjustHeap(list,i);
        }
    }
    public void adjustToTop(List<Integer> list,int i){
        int maxIndex = i;
        System.out.println("!!!");
        if (i%2==0 && i/2-1>=0 && list.get(i/2-1)<list.get(maxIndex)){
            maxIndex = i/2-1;
        }
        if (i%2==1 && i/2>=0&&list.get(i/2)<list.get(maxIndex)){
            maxIndex = i/2;
        }
        if (maxIndex!=i){
            swap(list,i,maxIndex);
            adjustHeap(list,maxIndex);
            if (i==0){
                return;
            }
            adjustToTop(list,i);
            System.out.println("!@@@");
        }
    }

    public void adjustHeap(List<Integer> list,int i){
        int maxIndex = i;

        if (i*2<list.size()&&list.get(i*2)<list.get(maxIndex)){
            maxIndex = i*2;
        }
        if (i*2+1<list.size()&&list.get(i*2+1)<list.get(maxIndex)){
            maxIndex = i*2+1;
        }
        if (maxIndex!=i){
            swap(list,i,maxIndex);
            adjustHeap(list,maxIndex);
        }
    }
    public void swap(List<Integer> list,int i,int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}
