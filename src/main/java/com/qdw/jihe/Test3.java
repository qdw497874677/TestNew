package com.qdw.jihe;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.qdw.jihe
 * @ClassName: Test3
 * @Description:
 * @date: 2020/9/24 0024 0:54
 */
public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer integer : list) {
            list.remove(integer);
        }
    }
}
