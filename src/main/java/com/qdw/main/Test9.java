package com.qdw.main;

import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            for (int j = 0; j < split.length; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }
        double max = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                double min = Math.min((double) (arr[i][0] + arr[j][0]) / 2, (double) (arr[i][1] + arr[j][1]) / 2);
//                max = Math.max(max,min);
//            }
//        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double min = Math.min((double) (arr[i][0] + arr[j][0]) / 2, (double) (arr[i][1] + arr[j][1]) / 2);
                max = Math.max(max,min);
            }
        }
        int maxa = 0;
        int maxb = 0;
        int[] arr2 = new int[n];
        double[][] dp = new double[n+1][2];
//        dp[0] = Math.min((double) (arr[0][0] + arr[0][0]) / 2, (double) (arr[i][1] + arr[j][1]) / 2);
//        dp[1] = Math.min((double) (arr[0][0] + arr[0][0]) / 2, (double) (arr[1][1] + arr[1][1]) / 2);
        dp[1][0] = (double) (arr[0][0] + arr[0][0]) / 2;
        dp[1][1] = (double) (arr[1][1] + arr[1][1]) / 2;
        for (int i = 2; i < n+1; i++) {

        }
        System.out.println(max);
    }
}
