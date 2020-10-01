package com.qdw.test;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int lcm = lcm(i,j);
                int gcd = gcd(i,j);
//                System.out.println(lcm+"--"+gcd+"   "+(lcm-gcd));
                max = Math.max(max,lcm-gcd);
            }
        }
        System.out.println(max);


    }
    public static int gcd(int a,int b){

        return b==0?a:gcd(b,a%b);
    }
    public static int lcm(int a,int b){

//        return ((a*b)/gcd(a,b));
        return a/gcd(a,b)*b;
    }

}
