package com.qdw.guanglianda;

import java.util.*;

/**
 * @PackageName:com.qdw.guanglianda
 * @ClassName: Test2
 * @Description:
 * @date: 2020/7/29 0029 20:33
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        if (n==0){
            return;
        }
        sc.nextLine();
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(arr,(a,b)->{
            return b-a;
        });
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
//            int cur = Integer.parseInt(ss[i]);
            int cur = arr[i];
            while (!stack.isEmpty() && stack.peekFirst()==cur){
                stack.pollFirst();
                cur = 2*cur;
            }
            stack.addFirst(cur);
        }
        n = stack.size();
        arr = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = stack.pollLast();
//        }
//        Arrays.sort(arr,(a,b)->{
//            return b-a;
//        });
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i]+" ");
//        }
        for (int i = 0; i < n; i++) {
            System.out.print(stack.pollLast()+" ");
        }
    }
}
