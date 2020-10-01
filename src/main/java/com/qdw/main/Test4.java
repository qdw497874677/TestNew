package com.qdw.main;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            String ar1 = sc.nextLine();
            String[] s1 = ar1.split(" ");
            String ar2 = sc.nextLine();
            String[] s2 = ar2.split(" ");
            int[] arr1 = new int[n];
            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(s1[j]);
            }
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) {
                arr2[j] = Integer.parseInt(s2[j]);
            }
            int temp=0;
            boolean flag = false;
            for (int j = 0; j < n; j++) {

                if (arr1[j] != arr2[j]){
                    if (flag && arr1[j-1] == arr2[j-1]){
                        System.out.println("NO");
                        break;
                    }
                    flag = true;
                    int now = arr1[j]-arr2[j];
                    if (temp==0){
                        temp = now;
                    }else if (temp!=now){
                        System.out.println("NO");
                        break;
                    }
                }
                if (j==n-1){
                    System.out.println("YES");
                }
            }
        }
    }

}
