package com.qdw.qianxin;

import java.util.Scanner;

/**
 * @PackageName:com.qdw.qi
 * @ClassName: Test1
 * @Description:
 * @date: 2020/8/1 0001 15:24
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int t = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());
            int[] p = new int[n];
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                String[] s = sc.nextLine().split(" ");
                p[i] = Integer.parseInt(s[0]);
                w[i] = Integer.parseInt(s[1]);
            }
            test(t,n,p,w);
        }

//        int[] p = new int[]{20,42,52,21,62,12,61};
//        int[] w = new int[]{12,52,61,24,15,98,76};
//        int n = 7;
//        int t = 200;
//        test(t,n,p,w);
    }
    public static void test(int t,int n,int[] p,int[] w){
        if (t==0 || n==0){
            System.out.println(0);
            return;
        }
        int[] dp = new int[t+1];
        for (int i = 0; i < n; i++) {
            int pp = p[i];
            int ww = w[i];
            for (int j = t; j >= pp; j--) {
                dp[j] = Math.max(dp[j],dp[j-pp]+ww);
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println(dp[t]);
    }
}
