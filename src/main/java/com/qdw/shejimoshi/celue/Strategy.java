package com.qdw.shejimoshi.celue;

// 根据给定的数组，打印升序的数组，并打印
public interface Strategy {
    void setData(Integer[] arr);
    void sort();
    void print();
}


