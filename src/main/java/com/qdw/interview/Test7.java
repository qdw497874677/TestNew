package com.qdw.interview;

import java.util.Scanner;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test7
 * @Description:
 * @date: 2020/5/28 0028 19:29
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        boolean flag = false;
        int pre = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1]>arr[i]){
                if (!flag){
                    if (i-2>=0){
                        arr[i-1] = arr[i-2];
                    }else {
                        arr[i-1] = arr[i];
                    }

                    flag = true;
                }else {
                    System.out.println("false");
                    return;
                }
            }
            pre = arr[i];
        }
        System.out.println("true");
        return;
    }
}
