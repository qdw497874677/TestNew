package com.qdw.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int j = 0; j < n; j++){
            arr[j] = scanner.nextInt();
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int[] a = new int[2];
            for(int j = 0; j < 2; j++){
                a[j] = scanner.nextInt();
            }
            list.add(a);
        }

    }
}
