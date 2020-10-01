package com.qdw.test427;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    }
    public int[][] convert(TreeNode root) {
        // write code here

        List<Integer> q = q(root);
        List<Integer> z = z(root);
        List<Integer> h = h(root);
        int[][] res = new int[3][q.size()];
        int i = 0;
        for (Integer integer : q) {
            res[0][i++] = integer;
        }
        i=0;
        for (Integer integer : q) {
            res[1][i++] = integer;
        }
        i=0;
        for (Integer integer : q) {
            res[2][i++] = integer;
        }
        return res;

    }
    public List<Integer> q(TreeNode root){
        if (root != null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
//        res.add(root.val);
//        res.addAll(q(root.left));
//        res.addAll(q(root.right));
        return res;
    }
    public List<Integer> z(TreeNode root){
        if (root != null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

//        res.addAll(q(root.left));
//        res.add(root.val);
//        res.addAll(q(root.right));
        return res;
    }
    public List<Integer> h(TreeNode root){
        if (root != null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

//        res.addAll(q(root.left));
//        res.addAll(q(root.right));
//        res.add(root.val);
        return res;
    }


}

class TreeNode1 {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode1(int val) {
        this.val = val;
    }
}
