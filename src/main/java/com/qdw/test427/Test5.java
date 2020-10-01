package com.qdw.test427;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Scanner;

/**
 * @PackageName:com.qdw.test427
 * @ClassName: Test5
 * @Description:
 * @date 2020/5/13 0013 19:48
 */
public class Test5 {
    public static void main(String[] args) {

    }
    static int engthOfLongestSubstr(String s) {
        int[] freq = new int[256];
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        int res = 0;
        int n = s.length();
        while (i<n && j<n){
            if (freq[chars[j]]==0){
                freq[chars[j++]]++;
                res = Math.max(res,j-i);
            }else {
                freq[chars[i++]]--;
            }
        }
        return res;
    }
    static int isReserveSame() {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return helper(s,0,s.length()-1);
    }
    static int helper(String s,int i,int j) {
        if (i==j || j-i==1){
            return 1;
        }
        if (s.charAt(i) == s.charAt(j) && helper(s,i+1,j-1)==1){
            return 1;
        }
        return 0;

    }
}
