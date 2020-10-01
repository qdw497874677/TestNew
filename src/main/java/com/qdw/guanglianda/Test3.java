package com.qdw.guanglianda;

import java.util.*;

/**
 * @PackageName:com.qdw.guanglianda
 * @ClassName: Test3
 * @Description:
 * @date: 2020/7/29 0029 20:33
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        s = sc.nextLine();
        s1 = s.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((arr[j-1]^arr[j]) == arr[j]){
                    if (map.containsKey(arr[j-1])){
                        map.get(arr[j-1]).add(arr[j]);
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[j]);
                        map.put(arr[j-1],list);
                    }
                }
            }
        }
    }
}
