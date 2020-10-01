package com.qdw.Test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<int[][]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[][] arr = new int[6][2];
            for (int j = 0; j < 6; j++) {
                String s = sc.nextLine();
                String[] s1 = s.split(" ");
                arr[j][0] = Integer.parseInt(s1[0]);
                arr[j][1] = Integer.parseInt(s1[1]);
            }
            list.add(arr);
        }
        for (int[][] ints : list) {
            Arrays.sort(ints,(a, b)->{
                return a[0]-b[0];
            });
            int max = 1;
            int count = 1;
            for (int i = 1; i < 6; i++) {
                if (ints[i-1][0]==ints[i][0]){
                    count++;
                    max = Math.max(max,count);
                }else {
                    count = 1;
                }
            }
            count = 1;
            for (int i = 1; i < 6; i++) {
                if (ints[i-1][1]==ints[i][1]){
                    count++;
                    max = Math.max(max,count);
                }else {
                    count = 1;
                }
            }
            if (max<4){
                System.out.println("IMPOSSIBLE");
            }else {
                System.out.println("POSSIBLE");
            }

            AtomicInteger a;
        }
    }
}
