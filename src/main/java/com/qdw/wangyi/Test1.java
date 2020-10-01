package com.qdw.wangyi;

import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

/**
 * @PackageName:com.qdw.wangyi
 * @ClassName: Test1
 * @Description:
 * @date: 2020/8/8 0008 13:24
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int cur = a/2;
            res += cur;
        }
        System.out.println(res);
    }
}
