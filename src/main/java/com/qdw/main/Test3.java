package com.qdw.main;

import java.util.Scanner;
import java.util.Stack;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static String test(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = {"surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};

        for (String word : words) {
            int sl = s.length();
            int wl = word.length();
            if (sl > wl+2 || sl < wl-2){
                continue;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < wl; i++) {
                stack.add(word.charAt(i));
            }
            int i = 0;
            int temp = 2;
//            boolean flag = false;
            while (!stack.isEmpty()){
                if (i == sl){
                    break;
                }
                if (stack.peek() == s.charAt(i++)){
                    stack.pop();
                    continue;
                }
//                else {
//                    stack.pop();
//                    temp--;
//                }
//                if (temp < 0){
//                    break;
//                }

            }
            if (stack.isEmpty()){
                return word;
            }

        }
        return "null";
    }
}
