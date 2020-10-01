package com.qdw.interview.kstest426;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = "";
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (String s1 : arr) {
//            for (String s2 : s1.split("/")) {
//                System.out.print(s2+" ");
//
//            }
            String[] split = s1.split("/");
            if (split.length<=3){
//                System.out.println("?");
                continue;
            }
            Set<String> set = map.get(split[2]);
            if (set==null){
                set = new HashSet<>();
                map.put(split[2],set);
//                System.out.println("!");
            }
            StringBuilder sb = new StringBuilder(split[3]);
            if (split.length>4){
                for (int i = 4; i < split.length; i++) {
                    sb.append("/");
                    sb.append(split[i]);
                }
            }
            set.add(sb.toString());
//            System.out.println(split[0]+"//"+split[2]);
        }
        Map<Set<String>,Set<String>> res = new HashMap<>();
        for (String s1 : map.keySet()) {
//            System.out.println(s1+": ");
            Set<String> strings = res.get(map.get(s1));
            if (strings==null){
                strings = new HashSet<>();
                res.put(map.get(s1),strings);
            }
            strings.add(s1);
//            for (String s2 : map.get(s1)) {
//                System.out.print(s2+" ");
//            }
//            System.out.println();
        }
        int resSize = res.size();
        for (Set<String> strings : res.keySet()) {
            if (res.get(strings).size()<=1){
                resSize--;
            }
        }
        System.out.println(resSize);
        for (Set<String> strings : res.keySet()) {
            if (res.get(strings).size()>1){
                for (String s1 : res.get(strings)) {
                    System.out.print("http://"+s1+" ");
                }
//                for (String string : strings) {
//                    System.out.print(string+" ");
//                }
                System.out.println();
            }

//            System.out.print(res.get(strings).size());

        }
    }
//    10
//    http://google.ru/test
//    http://google.ru/
//    http://google.com
//    http://google.com/test
//    http://google.de/
//    http://google.ru/test
//    http://google.de/test
//    http://google.com/
//    http://google.com/t
//    http://google.com/test
}
