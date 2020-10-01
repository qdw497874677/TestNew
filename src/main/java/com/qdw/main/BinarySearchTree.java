package com.qdw.main;
public class BinarySearchTree {
    private int data;
    private BinarySearchTree left;
    private BinarySearchTree right;
    private int count;
    public BinarySearchTree(int data){
        this.data = data;
        left = null;
        right = null;
        count = 1;
    }
    public BinarySearchTree insert(BinarySearchTree root,int data){
        if (root==null){
            return new BinarySearchTree(data);
        }
        if (data < root.data){
            root.left = insert(root.left,data);
        }else if (data > root.data){
            root.right = insert(root.right,data);
        }else {
            root.count++;
        }
        return root;
    }
    public void inorder(BinarySearchTree root){
        if (root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(50);
        root.insert(root,30);
        root.insert(root,20);
        root.insert(root,40);
        root.insert(root,60);
        root.insert(root,10);
        root.inorder(root);
    }
}

