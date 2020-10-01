package com.qdw.wangyi;

import java.util.Scanner;

/**
 * @PackageName:com.qdw.wangyi
 * @ClassName: Test2
 * @Description:
 * @date: 2020/8/8 0008 13:24
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String[] s2 = sc.nextLine().split(" ");
        int[] arr = new int[m];
        int[] res = new int[n];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(s2[i]);
            res[arr[i]-1]++;
        }
        int j = 0;
        int i = 0;
        while(i<n || j<m){
            if (i<n && res[i]==1){
                i++;
                continue;
            }
            if (j>=m){
                System.out.print(++i + " ");
                continue;
            }
            if (i+1<arr[j]){
                System.out.print(++i + " ");
            }else {
                System.out.print(arr[j++] + " ");
            }
        }
        System.out.println();

    }

}
