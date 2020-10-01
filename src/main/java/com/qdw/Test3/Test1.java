package com.qdw.Test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            arr[i][0] = Integer.parseInt(s1[0]);
            arr[i][1] = Integer.parseInt(s1[1]);
        }
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        if (n == 1){
            System.out.println(1);
            return;
        }
        int res = 1;
        int count = 1;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (!(arr[i][1]<arr[j][0] || arr[i][0]>arr[j][1])){
                    count++;
                    res = Math.max(res,count);
                }else {
                    count = 1;
                }
            }
        }

        System.out.println(res);

    }
}
