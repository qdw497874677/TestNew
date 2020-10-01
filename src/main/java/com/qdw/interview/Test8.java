package com.qdw.interview;

import java.util.Scanner;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test8
 * @Description:
 * @date: 2020/5/28 0028 19:36
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder s1 = new StringBuilder(s);
        char[] chars = s.toCharArray();
        int i = chars.length-1;
        for (;i > 0; i--) {
            if (cheak(s,0,i)){
                break;
            }
        }
        StringBuilder s2 = new StringBuilder(s1.substring(i + 1, s1.length()));
        s2.reverse().append(s1);
        System.out.println(s2);

    }
    public static boolean cheak(String s,int start,int end){
        if (start == end){
            return true;
        }
        if (s.charAt(start)!=s.charAt(end)){
            return false;
        }
        if (start == end+1){
            return true;
        }
        return cheak(s,start+1,end-1);
    }
}
