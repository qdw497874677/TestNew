package com.qdw.yuanfudao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @PackageName:com.qdw.yuanfudao
 * @ClassName: Test4
 * @Description:
 * @date: 2020/8/1 0001 21:26
 */
public class Test4 {
    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2},{2,3},{4,5},{1,3},{2,5}};
        Arrays.sort(arr,(a,b)->{
            return a[1]-b[1];
        });
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int[] ints : arr) {
            map.put(ints[0],map.getOrDefault(ints[0],0)+1);
        }
        int res = 1;
        int pre = 0;
        for (Integer integer : map.keySet()) {
            res = Math.max(res,map.get(integer)-pre);
            pre = map.get(integer);
        }
        System.out.println(res);
    }
}
