package com.qdw.jihe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:com.qdw.jihe
 * @ClassName: Test2
 * @Description:
 * @date: 2020/9/17 0017 9:23
 */
public class Test2 {
    public static void main(String[] args) {
        new HashMap<>();

        int i = 100;
        Set<Integer> set = new HashSet<>();
        while (i-->0){
            set.add(i);
        }
        for (Integer integer : set) {
            System.out.println(integer+" ");
        }
    }
}
