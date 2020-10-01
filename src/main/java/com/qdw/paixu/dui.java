package com.qdw.paixu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * @PackageName:com.qdw.paixu
 * @ClassName: dui
 * @Description:
 * @date: 2020/9/20 0020 14:06
 */
public class dui {
    public static void main(String[] args) {
        int n = 100;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    static int len;
    public static int[] heapSort(int[] arr){
        len = arr.length;
        if (len<1){
            return arr;
        }
        // 构建最大堆
        buildMaxHeap(arr);
        // 循环将堆顶和末位交换并减少长度(相当于把堆顶元素移除)，重新调整堆
        while (len>0){
            swap(arr,0,len-1);
            len--;
            adjustHeap(arr,0);
        }
        return arr;
    }

    public static void buildMaxHeap(int[] arr){
        // 从最后一个非叶子节点构造最大堆
        for (int i = (len/2-1); i >= 0; i--) {
            adjustHeap(arr,i);
        }
    }

    public static void adjustHeap(int[] arr,int i){
        int maxIndex = i;
        if (i*2<len && arr[i*2]>arr[maxIndex]){
            maxIndex = i*2;
        }
        if (i*2+1<len && arr[i*2+1]>arr[maxIndex]){
            maxIndex = i*2+1;
        }
        if (maxIndex!=i){
            swap(arr,i,maxIndex);
            // 递归地调整
            adjustHeap(arr,maxIndex);
        }
    }


    public static void adjustHeap2(int[] arr,int i){
        int maxIndex = i;
        if(i*2<arr.length&&arr[maxIndex]<arr[i*2]){
            maxIndex = i*2;
        }
        if(i*2+1<arr.length&&arr[maxIndex]<arr[i*2+1]){
            maxIndex = i*2+1;
        }
        if (maxIndex!=i){
            swap(arr,i,maxIndex);
            adjustHeap2(arr,maxIndex);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
