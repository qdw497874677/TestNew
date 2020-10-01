package com.qdw.yuanfudao;

import javafx.util.Pair;

import java.util.*;

/**
 * @PackageName:com.qdw.yuanfudao
 * @ClassName: Test1
 * @Description:
 * @date: 2020/8/1 0001 19:23
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        int num = 0;
        while(arr.length>0){
            num++;
            Arrays.sort(arr,(a,b)->{
                if (a[0]!=b[0]){
                    return a[0]-b[0];
                }else {
                    return b[1]-a[0];
                }
            });
            Map<Integer,List<Integer>> dp = new HashMap<>();
            int res = 0;
            int index = -1;
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                dp.put(i,list);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i][0]>=arr[j][1]){
                        if (dp.get(j).size()+1 > dp.get(i).size()){
                            List<Integer> list = new ArrayList<>();
                            list.addAll(dp.get(j));
                            list.add(i);
                            dp.put(i,list);
                        }
                    }
                }
                if (res < dp.get(i).size()){
                    res = dp.get(i).size();
                    index = i;
                }
            }
            int newN = n-res;
            if (newN <= 0 ){
                break;
            }
            List<Integer> list = dp.get(index);
            int[][] arr2 = new int[newN][2];
            int newI = 0;
            for (int i = 0; i < n; i++) {
                if (!list.contains(i)){
                    arr2[newI][0] = arr[i][0];
                    arr2[newI][1] = arr[i][1];
                    newI++;
                }
            }

            arr = arr2;
            n = newN;
        }
        System.out.println(num);

    }
}
