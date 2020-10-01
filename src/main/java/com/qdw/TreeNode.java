package com.qdw;

/**
 * @PackageName:com.qdw
 * @ClassName: TreeNode
 * @Description:
 * @date: 2020/8/8 0008 13:26
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

    @Override
    public String toString(){
        String s = " "+val+" ";
        System.out.println(s);
        return s;
    }
}
