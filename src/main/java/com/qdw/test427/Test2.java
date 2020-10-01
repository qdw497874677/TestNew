package com.qdw.test427;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        MinCost minCost = new MinCost();
        System.out.println(minCost.findMinCost("abc", 3, "adc", 3, 5, 3, 100));

    }
    public static class MinCost {
        public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
            // write code here

//            if (n*m==0){
//                return n+m;
//            }
            int[][] dp = new int[n+1][m+1];

            for (int i = 0; i < n+1; i++) {
                dp[i][0] = i*c1;
            }
            for (int i = 0; i < m + 1; i++) {
                dp[0][i] = i*c0;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    int l = dp[i-1][j]+c0;
                    int u = dp[i][j-1]+c1;
                    int lu = dp[i-1][j-1];
                    if (A.charAt(i-1) != B.charAt(j-1)){
                        lu += c2;
                    }
                    dp[i][j] = Math.min(lu,Math.min(l,u));
                }
            }
            return dp[n][m];
        }

    }
}
