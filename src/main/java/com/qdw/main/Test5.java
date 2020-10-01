package com.qdw.main;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String arra = sc.nextLine();
        String arrb = sc.nextLine();
        String[] sa = arra.split(" ");
        String[] sb = arrb.split(" ");
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sa[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(sb[i]);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res += b[i];
            int[] dp = new int[b[i]+1];
//            for (int j = 0; j < b[i]; j++) {
//                for (int k = n-1; k >= 0; k--) {
//                    if (a[k]<=j){
//                        dp[j] = Math.max(dp[j],dp[j-a[k]]+a[k]);
//                    }
//                }
//            }
            for (int j = 0; j < n; j++) {
                for (int k = b[i]; k >= 0; k--) {
                    if (k>=a[j]){
                        dp[k] = Math.max(dp[k],Math.max(a[j],dp[k-a[j]]+a[j]));
                    }
                }
            }
            System.out.println("!"+dp[b[i]-1]);
            res -= dp[b[i]-1];
        }
        System.out.println(res);
    }
}
