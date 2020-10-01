package com.qdw.interview.baidu;

/**
 * @Description:
 * @date: 2020/8/4 0004 20:23
 */
public class Test1 {
    int length = 16;
    double load = 0.75;
    int size = 0;
    private Node[] nodes = new Node[length];


    public Object get(Object key){
        int index = getIndex(key);
        Node p = nodes[index];
        while(p != null){
            if(key.equals(p.key)){
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public void put(Object key,Object value){
        int index = getIndex(key);
        Node e = new Node(key,value);
        if (nodes[index]==null){
            nodes[index] = e;
            return;
        }
        Node p = nodes[index];
        Node head = p;
        while(p!=null){
            if (key.hashCode()==p.key.hashCode() || key.equals(p.key)){
                p = e;
                return;
            }
            p = p.next;
        }
        nodes[index] = e;
        e.next = head;

    }

    private void grow(){

    }

    private int getIndex(Object key){
        int hashCode = key.hashCode();
        return hashCode%length;
    }

    class Node{
        Object key;
        Object value;
        Node next;
        public Node(Object key,Object value){
            this.key = key;
            this.value = value;
        }
    }
}

//student id  学生信息

// score id  sid cid 分数

// class id  课程信息
// select av.(score.分数) from student s join score sc on s.id = sc.sid group by s.id

// select MAX(sc.分数) from class c join score sc on c.id=sc.cid group by c.id
