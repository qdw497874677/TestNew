package com.qdw.main;

import java.util.Arrays;
import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        if (n == 2){
            System.out.println(Math.abs(arr[0]-arr[1]));
            for (int i : arr) {
                System.out.print(i+" ");
            }
        }
        if (n == 1){
            System.out.println(0);
            System.out.println(arr[0]);
        }
        Arrays.sort(arr);
        int ans = 0;
        int[] res = new int[n];
        res[0] = arr[0];
        int l = 0;
        int r = n-1;
        for (int i = 0; i < n; i++) {
            res[i] = i%2==0?arr[l++]:arr[r--];
        }
        for (int i = 1; i < n; i++) {
            ans += Math.abs(res[i]-res[i-1]);
        }
        ans += Math.abs(res[0]-res[n-1]);
        System.out.println(ans);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}
