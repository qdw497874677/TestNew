package com.qdw.test;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.*;

public class Test {

    @org.junit.Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int ns = Integer.parseInt(s.split(" ")[0]);
        int nt = Integer.parseInt(s.split(" ")[1]);
        String[] ans = new String[ns + 1];
        for (int i = 0; i < ns + 1; i++) {
            scanner.nextLine();
            ans[i] = scanner.nextLine();
        }
        char[] chars = ans[ns + 1].toCharArray();
        int[] score = new int[nt + 1];
        for (int i = 0; i < chars.length; i++) {
            score[i] = chars[i]-'a';
        }
    }

    @org.junit.Test
    public void test2(){
        int[] a = {3,1,2};
        Integer[] b = {3,1,2};
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        Arrays.sort(a);

        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });

        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (Integer integer : b) {
            System.out.print(integer+" ");
        }
    }
    @org.junit.Test
    public void test3(){
        List<Integer> list = new ArrayList<Integer>();

        int[][] pairs = {{1,2},{3,1},{2,3}};
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);

    }
    @org.junit.Test
    public void test4(){

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        int i=0;
        while(scanner.hasNext()){
            arr[i] = scanner.nextInt();
            i++;
        }
    }

}
