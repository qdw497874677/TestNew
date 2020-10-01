package com.qdw.interview.kstest426;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s1 = sc.nextLine().split(" ");
        int m = Integer.parseInt(s1[0]);
        int n = Integer.parseInt(s1[1]);
        if (m==0 || n==0){
            System.out.println(0);
            return;
        }
//        sc.nextLine();
        String s = "";
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) {
            s = sc.nextLine();
            String[] s2 = s.split(" ");
            for (int j = 0; j < n; j++) {
                g[i][j] = Integer.parseInt(s2[j]);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                if (g[i][j]== 1){
                    if (helper(g,i,j,0)){
                        res++;
                    }
                }

            }
        }
//        System.out.println(res);
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(g[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(helper(g,3,3,0));

    }
    public static boolean helper(int[][] g,int i,int j,int index){
        if (i<0 || j<0 || i>=g.length || j>=g[0].length){
//            System.out.println("!");
//            System.out.println("?");
            return false;
        }
        if (g[i][i]==0){
            if (index==0){
                return false;
            }else {
                System.out.println("!");
                return true;
            }
        }
        if (g[i][j]==-1){
            System.out.println("?"+i+" "+j);
            if (index==0){
                return false;
            }else {
                return true;
            }

        }
        g[i][j]=-1;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        boolean res = true;
        for (int k = 0; k < 4; k++) {

            res = res && helper(g,i+dx[k],j+dy[k],index+1);
        }
        return res;
    }
}
