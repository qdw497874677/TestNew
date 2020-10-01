package com.qdw.genshuixue;


/**
 * @PackageName:com.qdw.genshuixue
 * @ClassName: Test2
 * @Description:
 * @date: 2020/8/7 0007 19:39
 */
public class Test2 {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        n1.setNext(4).setNext(6).setNext(7);
        Node n2 = new Node(1);
        n2.setNext(3).setNext(5).setNext(8);

        Node node = mergeTwoLists(n1, n2);
        while (node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    static class Node{
        int data;
        public Node(int data){
            this.data = data;
        }
        public Node setNext(int data){
            next = new Node(data);
            return next;
        }
        Node next;
    }

    public static Node mergeTwoLists(Node n1,Node n2){
        Node head = new Node(-1);
        Node p = head;
        while(n1!=null && n2!=null){
            if (n1.data < n2.data){
                p.next = n1;
                p = p.next;
                n1 = n1.next;
            }else {
                p.next = n2;
                p = p.next;
                n2 = n2.next;
            }
        }
        p = n1!=null?n1:n2;
        return head.next;
    }
}
