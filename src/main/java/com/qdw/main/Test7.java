package com.qdw.main;

import java.util.Arrays;
import java.util.Scanner;

public class Test7 {
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
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (a[j]<=b[i]){
                    max = Math.max(a[j],max);
                }
            }
            res -= max;
        }
        System.out.println(res);

    }
    public void f(){




//        public class Main {
//            public static void main(String[] args) {
//
//                Scanner sc = new Scanner(System.in);
//                int t = sc.nextInt();
//
//                for (int i = 0; i < t; i++) {
//                    int n = sc.nextInt();
//                    sc.nextLine();
//                    String ar1 = sc.nextLine();
//                    String[] s1 = ar1.split(" ");
//                    String ar2 = sc.nextLine();
//                    String[] s2 = ar2.split(" ");
//                    int[] arr1 = new int[n];
//                    for (int j = 0; j < n; j++) {
//                        arr1[j] = Integer.parseInt(s1[j]);
//                    }
//                    int[] arr2 = new int[n];
//                    for (int j = 0; j < n; j++) {
//                        arr2[j] = Integer.parseInt(s2[j]);
//                    }
//                    int temp=0;
//                    boolean flag = false;
//                    for (int j = 0; j < n; j++) {
//                        if (arr1[j] != arr2[j]){
//
//                            if (temp!=0){
//                                if (arr1[j]-arr2[j]!=temp){
//                                    System.out.println("NO");
//                                    break;
//                                }
//                            }else {
//                                if (flag){
//                                    System.out.println("NO");
//                                    break;
//                                }
//                                temp = arr1[j]-arr2[j];
//                            }
//
//                            flag = true;
//                        }
//                        if (j==n-1){
//                            System.out.println("YES");
//                        }
//                    }
//                }
//            }
//
//        }
//
    }
}
