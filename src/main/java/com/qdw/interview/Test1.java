package com.qdw.interview;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test1
 * @Description:
 * @date 2020/5/15 0015 0:33
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);
        if (m==0 || n==0){
            System.out.println(0);
            return;
        }
        int res = 0;
        if(m%2 == 0){
            if(n%2 == 0){
                res = (m/2) * (n/2);
            }else {
                res = (m/2) * (n/2) + m/2;
            }
        }else {
            if(n%2 == 0){
                res = (m/2) * (n/2) + n/2;
            }else {
                res = (m/2) * (n/2) + n/2 + m/2 + 1;
            }
        }
        System.out.println(res);
    }

}
