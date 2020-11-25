package com.qdw.yuanfudao;

/**
 * @PackageName:com.qdw.yuanfudao
 * @ClassName: Test5
 * @Description:
 * @date: 2020/10/13 0013 12:24
 */
public class Test5 {
    public static void main(String[] args) {

        int res = m(10);
        System.out.println(res);

    }

    public static int m(int x){
        if (x<=0){
            return 0;
        }
        int l = 1;
        int r = x;
        while (r-l>1){
            int mid = l+(r-l)/2;
            if (x/mid<mid){
                r = mid;
            }else {
                l = mid;
            }
        }
        return l;
    }
}
