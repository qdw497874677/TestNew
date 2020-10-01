package com.qdw.interview.baidu;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @date: 2020/8/4 0004 20:23
 */
public class Test2 {
    public static void main(String[] args) {

    }
    public List<Integer> method(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        if(root.left!=null){
            res.addAll(method(root.left));
        }
        res.add(root.val);
        if(root.right!=null){
            res.addAll(method(root.right));
        }
        return res;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}


