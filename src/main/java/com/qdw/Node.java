package com.qdw;

/**
 * @PackageName:com.qdw
 * @ClassName: Node
 * @Description:
 * @date: 2020/8/8 0008 13:25
 */
public class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString(){
        String s = " "+val+" ";
        System.out.println(s);
        return s;
    }
}
