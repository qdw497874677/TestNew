package com.qdw.paixu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * @PackageName:com.qdw.paixu
 * @ClassName: kuaipai
 * @Description:
 * @date: 2020/9/20 0020 14:06
 */
public class kuaipai {


    static Random random = new Random();
    public static int[] sort(int[] arr,int l,int r){
        if (l<r){
            int mid = part(arr,l,r);
            sort(arr,l,mid-1);
            sort(arr,mid+1,r);
        }
        return arr;

    }
    public static int part(int[] arr,int l,int r){
        int t = random.nextInt(r-l)+1;
        int temp = arr[l];
        arr[l] = arr[t];
        int index = temp;
//        int index = arr[l];
        while (l<r){
//            while (l<r && arr[r]>=index){
            while (l<r && arr[r]<=index){
                r--;
            }
            if (l<r){
                arr[l++] = arr[r];
            }
//            while (l<r && arr[l]<=index){
            while (l<r && arr[l]>=index){
                l++;
            }
            if (l<r){
                arr[r--] = arr[l];
            }
//            if (l<r){
//                int temp = arr[l];
//                arr[l] = arr[r];
//                arr[r] = temp;
//            }
        }

        arr[l] = index;
        return l;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        long start = System.currentTimeMillis();
        sort(arr,0,arr.length-1);
        System.out.println("耗时："+(System.currentTimeMillis()-start));
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
