package com.qdw.main;

public class Test2 {
    public static void main(String[] args) {
        long l = countDolphin(5, 5, new int[]{2, 2, 4}, 5);
        System.out.println(l);
    }

    static long countDolphin(int n, int m, int[] birthYear, int x) {
        long res = n;
        for (int i : birthYear) {
            if (i>m){
                break;
            }
            if (x<=i){
                return res;
            }
            res += n;

        }

        return res;

    }
}
