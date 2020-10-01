package com.qdw.guanglianda;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @PackageName:com.qdw.guanglianda
 * @ClassName: Test1
 * @Description:
 * @date: 2020/7/29 0029 20:33
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] s11 = s1.split(" ");
        int n = Integer.parseInt(s11[0]);
        int m = Integer.parseInt(s11[1]);
        int x = Integer.parseInt(s11[2]);
        String s2 = sc.nextLine();
        String[] s22 = s2.split(" ");
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(s22[i]));
        }
        for (int i = 0; i < m; i++) {
            Integer poll = queue.poll();
            queue.add(poll + x);
        }
        System.out.println(queue.poll());
    }
}
