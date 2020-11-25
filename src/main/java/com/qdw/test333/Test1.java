package com.qdw.test333;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Quandw
 * @Description: 两个链表 两个数字
 * @Date: 2020/11/12 0012 17:18
 */
public class Test1 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.setNext(2).setNext(3);

        ListNode listNode2 = new ListNode(1);
        listNode2.setNext(2).setNext(3);

        ListNode m = m(listNode1, listNode2);

        while (m!=null){
            System.out.println(m.val);
            m = m.next;
        }
    }

    public static ListNode m(ListNode l1,ListNode l2){
        ListNode head = null;
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        ListNode p = l1;
        while(p!=null){
            stack1.addFirst(p.val);
            p = p.next;
        }
        p = l2;
        while (p!=null){
            stack2.addFirst(p.val);
            p = p.next;
        }
        int pre = 0;
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            sum = 0;
            if (!stack1.isEmpty()){
                sum += stack1.pollFirst();
            }
            if (!stack2.isEmpty()){
                sum += stack2.pollFirst();
            }
            sum += pre;
            pre = sum/10;
            ListNode listNode = new ListNode(sum % 10);
            listNode.next = head;
            head = listNode;
        }
        if (pre!=0){
            ListNode listNode = new ListNode(pre);
            listNode.next = head;
            head = listNode;
        }
        return head;
    }

}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int a){
        val = a;
    }

    ListNode setNext(int a){
        ListNode listNode = new ListNode(a);
        next = listNode;
        return listNode;
    }


}
