package com.qdw.test;
import java.util.Comparator;
import java.util.Arrays;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
//        String [] s=scanner.nextLine().split(" ");
        int[] arr = new int[n];
//        int[] arr = new int[s.length];
        for(int j = 0; j < n; j++){
            arr[j] = scanner.nextInt();
        }
//        for(int i=0;i<s.length;i++){
//            arr[i] = Integer.parseInt(s[i]);
//        }
        Arrays.sort(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        int i=0;
        int length = arr.length;
        while (arr[length-1]>=n){
            arr[arr.length-1] -= n+1;
            for (int j = 0; j < length; j++) {
                arr[j] += 1;
            }
            Arrays.sort(arr);
            i++;
        }
        System.out.println(i);

    }
}
