package com.qdw.test;

import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int i1 = scanner.nextInt();
//        int i2 = scanner.nextInt();
//        System.out.println(i1);
//        System.out.println(i2);


//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        String[] array = new String[t];
//        for (int i = 0; i < t; ++i) {
//            array[i] = scanner.next();
//        }
//        for (String s : array) {
//            System.out.println(s);
//        }

        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String [] s=sc.nextLine().split(" ");
            int sum=0;
            for(int i=0;i<s.length;i++){
                sum=sum+Integer.parseInt(s[i]);
            }
            System.out.println(sum);
        }


    }
}
