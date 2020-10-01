package com.qdw.yuanfudao;

import java.util.*;

/**
 * @PackageName:com.qdw.yuanfudao
 * @ClassName: Test1
 * @Description:
 * @date: 2020/8/1 0001 19:23
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][2];
        Map<Integer,List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            List<Integer> list = null;
            if (map.containsKey(arr[i][1])){
                list = map.get(arr[i][1]);
            }else {
                list = new ArrayList<>();
            }
            list.add(arr[i][0]);
            map.put(arr[i][1],list);
        }
        if (n==1){
            System.out.println(arr[0][0]);
        }
        System.out.println(helper(map,0));
    }
    public static int helper(Map<Integer,List<Integer>> map,int index){
        if (!map.containsKey(index)){
            return 0;
        }
        int sum = 0;
        List<Integer> list = map.get(index);
        for (Integer integer : list) {
            int temp = integer + helper(map,integer);
            if (temp>0){
                sum += temp;
            }
        }
        return Math.max(sum, 0);
    }
}
