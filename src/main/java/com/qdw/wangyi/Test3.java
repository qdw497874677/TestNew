package com.qdw.wangyi;

import sun.swing.StringUIClientPropertyKey;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Test3 {
    static int res = Integer.MAX_VALUE;
    static List<Set<Integer>> lists;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().split(" ");
            int[] arr = new int[n];
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
                sum += sum;
                set.add(Integer.parseInt(s[i]));
            }

            for (Integer integer : set) {

            }
            boolean[] used = new boolean[n];
//            for (int i = 0; i < n; i++) {
//                helper(arr,used,0,sum,0);
//            }
//            helper(arr,used,0,sum,0);
            System.out.println(res);

        }
    }
    public static void helper(int[] arr, boolean[] used,int index,Set<Integer> cur, int curSum, int sum){
        if (index < arr.length || curSum<sum/2){
            lists.add(cur);
        }else {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]){
                used[i] = true;
                cur.add(arr[i]);
                helper(arr,used,index+1,cur,curSum+arr[i],sum);
                used[i] = false;
            }
        }
        return;
    }

}
