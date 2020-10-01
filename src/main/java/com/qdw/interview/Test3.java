package com.qdw.interview;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test3
 * @Description:
 * @date: 2020/5/18 0018 11:17
 */
public class Test3 {
    public static void main(String[] args) {
        int[] arr = {7,6,4,2,5,1};
        int target = 4;
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (arr[mid]==target){
                System.out.println(mid);
                return;
            }else if(arr[mid]>target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        System.out.println(-1);
    }
}
