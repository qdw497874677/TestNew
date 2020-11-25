package com.qdw.suanfalianxi;

import java.math.BigDecimal;

/**
 * @PackageName:com.qdw.suanfalianxi
 * @ClassName: Test1
 * @Description:
 * @date: 2020/11/4 0004 8:53
 */
public class Test1 {
    public static void main(String[] args) {
        double n = 10;
        double l = 1;
        double r = n;
        while(r-l>0.001){
            double mid = (r-l)/2+l;
            if(mid>n/mid){
                r = mid;
            }else {
                l = mid;
            }
        }
        double res = new BigDecimal(l).setScale(3, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        System.out.println(res);
    }
}
