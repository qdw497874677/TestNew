package com.qdw.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String [] s=scanner.nextLine().split(" ");
//        int[] arr = new int[s.length];
        PriorityQueue<Integer> arr = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<s.length;i++){
            arr.add(Integer.parseInt(s[i]));
        }
        int i = 0;
        int flag = 1;
        while (arr.peek()>=n){
            Integer poll = arr.poll()-n;
            i++;
            if (arr.peek()+flag<n){
                break;
            }
            arr.add(poll);
            flag++;
        }
        System.out.println(i);

    }
}
