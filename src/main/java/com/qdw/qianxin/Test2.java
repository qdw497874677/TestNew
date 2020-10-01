package com.qdw.qianxin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @PackageName:com.qdw.qi
 * @ClassName: Test1
 * @Description:
 * @date: 2020/8/1 0001 15:24
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.substring(1, s.length() - 1).split(",");
        int n = ss.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        boolean[] used = new boolean[n];
        System.out.println(helper(arr,0,new ArrayList<>(),used));

    }
    public static int helper(int[] arr, int index, List<Integer> list, boolean[] used){
        if(index == arr.length){
            int a = 0;
            int b = 1;
            for (Integer integer : list) {
                a += integer*b;
                b = b*10;
            }
            if (a%7==0){
                return 1;
            }else {
                return 0;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]){
                list.add(arr[i]);
                used[i] = true;
                res += helper(arr,index+1,list,used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
        return res;
    }
}
