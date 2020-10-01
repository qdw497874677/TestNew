package com.qdw.interview;

import java.util.Scanner;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test6
 * @Description:
 * @date: 2020/5/28 0028 19:24
 */
public class Test6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 3){
            System.out.println(n);
            return;
        }
        int pre2 = 1;
        int pre1 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre2 + pre1;
            pre2 = pre1;
            pre1 = res;
        }
        System.out.println(res);
    }
}
