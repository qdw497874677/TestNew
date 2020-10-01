package com.qdw.main;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class Test8 {
    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        TreeNode1 treeNode1 = reConstructBinaryTree(pre, in);
        System.out.println(treeNode1.val);
    }
    public static TreeNode1 reConstructBinaryTree(int[] pre, int[] in) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return reConstructBinaryTree(pre,0,pre.length-1,0,map);
    }
    private static TreeNode1 reConstructBinaryTree(int[] pre, int preL, int preR, int inL,Map<Integer,Integer> map) {
        if (preL>preR){
            return null;
        }

        TreeNode1 root = new TreeNode1(pre[preL]);
        int inIndex = map.get(root.val);
        int leftTreeSize = inIndex - inL;
        //从前序的preL+1到preL+leftTreeSize的都是左子树的，这部分从中序的inL开始
        root.left = reConstructBinaryTree(pre,preL+1,preL+leftTreeSize,inL,map);
        //从前序的preL+leftTreeSize+1到preR的都是右子树的，这部分从中序的inL+leftTreeSize+1开始
        root.right = reConstructBinaryTree(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1,map);
        return root;
//        if (preL > preR){
//            return null;
//        }
//        //从前序的左边获取一个值作为根节点
//        TreeNode1 root = new TreeNode1(pre[preL]);
//        //获取这个值在中序中的位置
//        int inIndex = map.get(root.val);
//        //这个位置-当前中序的左指针=左半个树的节点个数
//        int leftTreeSize = inIndex - inL;
//        //这个根节点的左叶子节点
//        //前序左指针+1，前序右指针+左半个树的节点个数
//        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL,map);
//        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1,map);
//        return root;
    }
}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) { val = x; }
}
