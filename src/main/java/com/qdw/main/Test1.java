package com.qdw.main;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {



    }

    static int calcMinStaff() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int res = 1;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            arr[i][0] = Integer.parseInt(s.split(",")[0]);
            arr[i][1] = Integer.parseInt(s.split(",")[1]);
        }
//        if (n == 1){
//            return 1;
//        }
//        if (n == 0){
//            return 0;
//        }
        int need = 1;
        for (int i = 1; i < n; i++) {
            int nowtime = arr[i][0];
            need = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][1] > nowtime){
                    need++;
                }else {
                    need--;
                }
            }
            if (need<0){
                need=0;
            }
            res = Math.max(res,need);

        }
        System.out.println(res);
        return res;

    }
}
