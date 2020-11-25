package com.qdw.xiancheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @PackageName:com.qdw.xiancheng
 * @ClassName: Test3
 * @Description:
 * @date: 2020/10/17 0017 14:43
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "test", "stet"};
        System.out.println(test3.groupAnagrams(strings));
    }

    public ArrayList<ArrayList<String>> groupAnagrams (String[] strs) {
        // write code here
        Map<String,ArrayList<String>> map = new LinkedHashMap<>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key =new String(chars);
            ArrayList<String> list = map.get(key);
            if(list==null){
                list = new ArrayList<>();
                map.put(key,list);

            }
            list.add(s);
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
