package com.qdw.genshuixue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackageName:com.qdw.genshuixue
 * @ClassName: Test1
 * @Description:
 * @date: 2020/8/7 0007 19:18
 */
public class Test1 {

    public static void main(String[] args) {
//        String s = "(abcd)";
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s){
        // 栈用来存结果
        Deque<Character> stack = new LinkedList<>();
        // 队列用来反转一对括号里的字符
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==')'){
                Character character = stack.pollFirst();
                // 将栈中要反转的字符放入队列
                while(character!='('){
                    queue.addFirst(character);
                    character = stack.pollFirst();
                }
                // 从队列拿出来压入栈
                while (!queue.isEmpty()){
                    stack.addFirst(queue.pollLast());
                }
            }else {
                stack.addFirst(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
